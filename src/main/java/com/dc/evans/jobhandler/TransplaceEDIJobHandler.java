package com.dc.evans.jobhandler;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.edi.bind.EDIUnmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dc.evans.edi.model.x12.edi.IEDIMessage;
import com.dc.evans.edi.model.x12.edi.IEDIMessageBody;
import com.dc.evans.edi.model.x12.edi204.v4010.Detail;
import com.dc.evans.edi.model.x12.edi204.v4010.Header;
import com.dc.evans.edi.model.x12.edi204.v4010.LadingDetailGroup;
import com.dc.evans.edi.model.x12.edi204.v4010.OrderDetailGroup;
import com.dc.evans.edi.model.x12.edi204.v4010.Shipment;
import com.dc.evans.edi.model.x12.edi204.v4010.ShipmentBody;
import com.dc.evans.edi.model.x12.edi204.v4010.ShipmentWeightAndQuantityDetailGroup;
import com.dc.evans.edi.model.x12.edi204.v4010.StopOffDetailContactGroup;
import com.dc.evans.edi.model.x12.edi204.v4010.StopOffDetailGroup;
import com.dc.evans.edi.model.x12.edi204.v4010.Trailer;
import com.dc.evans.edi.model.x12.segment.PersonContact;
import com.dc.evans.schema.mercurygate.Address;
import com.dc.evans.schema.mercurygate.Charge;
import com.dc.evans.schema.mercurygate.Charges;
import com.dc.evans.schema.mercurygate.Consignee;
import com.dc.evans.schema.mercurygate.Contact;
import com.dc.evans.schema.mercurygate.ContactMethod;
import com.dc.evans.schema.mercurygate.ContactMethods;
import com.dc.evans.schema.mercurygate.Contacts;
import com.dc.evans.schema.mercurygate.Date;
import com.dc.evans.schema.mercurygate.Dates;
import com.dc.evans.schema.mercurygate.Dimension;
import com.dc.evans.schema.mercurygate.Dimensions;
import com.dc.evans.schema.mercurygate.Drop;
import com.dc.evans.schema.mercurygate.Enterprise;
import com.dc.evans.schema.mercurygate.Event;
import com.dc.evans.schema.mercurygate.Events;
import com.dc.evans.schema.mercurygate.FreightClass;
import com.dc.evans.schema.mercurygate.FreightClasses;
import com.dc.evans.schema.mercurygate.ItemGroup;
import com.dc.evans.schema.mercurygate.ItemGroups;
import com.dc.evans.schema.mercurygate.LineItem;
import com.dc.evans.schema.mercurygate.Load;
import com.dc.evans.schema.mercurygate.MercuryGate;
import com.dc.evans.schema.mercurygate.NormalizedTotal;
import com.dc.evans.schema.mercurygate.Payment;
import com.dc.evans.schema.mercurygate.Pickup;
import com.dc.evans.schema.mercurygate.Plan;
import com.dc.evans.schema.mercurygate.PriceSheet;
import com.dc.evans.schema.mercurygate.PriceSheet.Carrier;
import com.dc.evans.schema.mercurygate.PriceSheet.Carrier.InsuranceTypes;
import com.dc.evans.schema.mercurygate.PriceSheet.Carrier.InsuranceTypes.Insurance;
import com.dc.evans.schema.mercurygate.PriceSheets;
import com.dc.evans.schema.mercurygate.Quantities;
import com.dc.evans.schema.mercurygate.Quantity;
import com.dc.evans.schema.mercurygate.ReferenceNumber;
import com.dc.evans.schema.mercurygate.ReferenceNumbers;
import com.dc.evans.schema.mercurygate.ServiceList;
import com.dc.evans.schema.mercurygate.ServiceRequest;
import com.dc.evans.schema.mercurygate.ServiceRequest.Data;
import com.dc.evans.schema.mercurygate.ServiceRequest.Data.WebImport;
import com.dc.evans.schema.mercurygate.ServiceRequest.Data.WebImport.WebImportFile;
import com.dc.evans.schema.mercurygate.ServiceRequest.Data.WebImport.WebImportHeader;
import com.dc.evans.schema.mercurygate.Shipments;
import com.dc.evans.schema.mercurygate.Shipper;
import com.dc.evans.schema.mercurygate.TypeLocationEnvelope;
import com.dc.evans.schema.mercurygate.Weight;
import com.dc.evans.schema.mercurygate.Weights;
import com.dc.evans.service.MailServiceImpl;
import com.dc.evans.util.EDIFileIdentifier;
import com.dc.evans.util.HttpClientUtil;
import com.dc.evans.util.HttpClientUtil.HttpProtocol;
import com.dc.evans.util.Utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

@Component
public class TransplaceEDIJobHandler {

	private static final Logger LOG = LoggerFactory.getLogger(TransplaceEDIJobHandler.class);

	@Value("${mg-endpoint}")
	private String mercuryGateEndpoint;

	@Value("${mg-auth}")
	private String mercuryGateAuth;
	
	@Autowired
	private MailServiceImpl mailService;
	
	@Value("${app.error.email.to}")
	public String fileProcessEmailTo;

	public void downloadMessage() {
		try {
			LOG.info("Checking for new Files");
			List<String> fileNames = Utils.downloadFiles();
			LOG.info("Found {} files in the SFTP", fileNames.size());
			List<String> processedOrderFile = new ArrayList<>();
			if (fileNames != null && !fileNames.isEmpty()) {
				boolean isAllSuccess = true;
				for (String fileName : fileNames) {
					try {
						LOG.info("Processing file: {}", fileName);
						Reader reader = new StringReader(
								FileUtils.readFileToString(new File(fileName), Charset.defaultCharset()));
						EDIFileIdentifier ediFileIdentifier = Utils.getEDIType(reader, IEDIMessage.class);
						LOG.info("File type: {} EDI Version: {}", ediFileIdentifier.getFileType(),
								ediFileIdentifier.getEdiVersion());
						if (ediFileIdentifier.getFileType() != null) {
							process(ediFileIdentifier, fileName);
							processedOrderFile.add(new File(fileName).getName());
						} else {
							LOG.error("Could not identify file: {}", fileName);
						}

					} catch (Exception e) {
						e.printStackTrace();
						isAllSuccess = false;
						mailService.sendErrorEmail(fileProcessEmailTo.split(","), "Error while processing EDI file: " + fileName, 
								"Error while processing EDI file: " + fileName + "\n\nError Stack: "+ e.getMessage(),e, new File(fileName));
					}
				}

				// Utils.deleteFile(account, processedOrderFile);
				if (!isAllSuccess) {
					throw new Exception("Failed to save all files");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("Inside AmazonJobHandler");
	}

	private void process(EDIFileIdentifier ediFileIdentifier, String fileName) throws Exception {
		if ("204".equalsIgnoreCase(ediFileIdentifier.getFileType().toLowerCase().trim())) {
			if (ediFileIdentifier.getEdiVersion() == 4010) {
				Shipment shipment = EDIUnmarshaller.unmarshal(Shipment.class,
						new StringReader(FileUtils.readFileToString(new File(fileName), Charset.defaultCharset())));
				generateMercuryGateXML(shipment);
			} else if (ediFileIdentifier.getEdiVersion() == 5010) {
				com.dc.evans.edi.model.x12.edi204.v5010.Shipment shipment = EDIUnmarshaller.unmarshal(com.dc.evans.edi.model.x12.edi204.v5010.Shipment.class,
						new StringReader(FileUtils.readFileToString(new File(fileName), Charset.defaultCharset())));
				generateMercuryGateXML(shipment);
			}
		} else if ("997".equalsIgnoreCase(ediFileIdentifier.getFileType().toLowerCase().trim())) {
			//
			return;
		}
	}

	public void generateMercuryGateXML(Shipment shipment) throws Exception {
		// Define the desired date format
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
		for (IEDIMessageBody<ShipmentBody> body : shipment.getBody()) {
			try {
				Header header = (Header) body.getHeader();
				Detail detail = (Detail) body.getDetail();
				Trailer trailer = (Trailer) body.getTrailer();

				LOG.info("Starting to send Shipment to Mercury Gate for Shipment: {}", header.getBeginningSegmentforInvoice().getShipmentRefNumber());
				
				// Create an instance of your object
				ServiceRequest serviceRequest = new ServiceRequest();
				serviceRequest.setServiceId("ImportWeb");
				serviceRequest.setRequestId(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
				Data data = new Data();
				WebImport webImport = new WebImport();
				ServiceRequest.Data.WebImport.WebImportFile webImportFile = new WebImportFile();
				
				webImport.setWebImportFile(webImportFile);
				ServiceRequest.Data.WebImport.WebImportHeader webImportHeader = new WebImportHeader();
				webImportHeader.setType("WebImportTransportManualRate");
				webImportHeader.setUserName("WebserviceUserEatonEDI");
				webImportHeader.setFileName(header.getBeginningSegmentforInvoice().getShipmentRefNumber()+".xml");
				webImport.setWebImportHeader(webImportHeader);
				data.setWebImport(webImport);
				serviceRequest.setData(data);
				MercuryGate mgShipment = new MercuryGate();
				com.dc.evans.schema.mercurygate.Header mgHeader = new com.dc.evans.schema.mercurygate.Header();
				mgHeader.setDocCount("1");
				mgHeader.setDocTypeID("MasterBillofLading");
				mgShipment.setHeader(mgHeader);
				// Populate the object with data
				Load load = new Load();
				load.setAction("UpdateOrAdd");

				Enterprise enterprise = new Enterprise();
				enterprise.setCustomerAcctNum("EATONWA2");
				load.setEnterprise(enterprise);

				ReferenceNumbers referenceNumbers = new ReferenceNumbers();

				ReferenceNumber bolReferenceNumber = new ReferenceNumber();
				bolReferenceNumber.setType("BOL");
				bolReferenceNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
				bolReferenceNumber.setIsPrimary("true");
				referenceNumbers.getReferenceNumber().add(bolReferenceNumber);

				ReferenceNumber autoAcceptReferenceNumber = new ReferenceNumber();
				autoAcceptReferenceNumber.setType("Auto Accept");
				autoAcceptReferenceNumber.setValue("true");
				autoAcceptReferenceNumber.setIsPrimary("false");
				referenceNumbers.getReferenceNumber().add(autoAcceptReferenceNumber);

				header.getBusinessInstruction().forEach(req -> {
					if ("DLH".equalsIgnoreCase(req.getReferenceDescription())
							|| "FSF".equalsIgnoreCase(req.getReferenceDescription())) {
						ReferenceNumber referenceNumber = new ReferenceNumber();
						referenceNumber.setType(req.getReferenceDescription());
						referenceNumber.setValue(req.getReferenceIdentificationQualifier());
						referenceNumber.setIsPrimary("false");
						referenceNumbers.getReferenceNumber().add(referenceNumber);
					}
				});

				load.setReferenceNumbers(referenceNumbers);

				Payment payment = new Payment();
				switch (header.getBeginningSegmentforInvoice().getPaymentMethod()) {
				case "PP" -> {
					payment.setMethod("Prepaid");

					TypeLocationEnvelope prepaid = new TypeLocationEnvelope();

					Address address = new Address();
					address.setName("EVANS TRANSPORTATION");
					address.setAddrLine1("400 GENESEE STREET");
					address.setAddrLine2("SUITE 3F");
					address.setCity("DELAFIELD");
					address.setStateProvince("WI");
					address.setPostalCode("53018");
					address.setCountryCode("USA");
					prepaid.setAddress(address);

					prepaid.setThirdParty("false");
					payment.setBillTo(prepaid);
				}
				case "CC" -> payment.setMethod("Collect");
				case "TP" -> payment.setMethod("Third Party");
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + header.getBeginningSegmentforInvoice().getPaymentMethod());
				}
				load.setPayment(payment);

				Plan plan = new Plan();

				Events events = new Events();

				int eventCount = 1;
				Address pickupAddress = new Address();
				Contacts pickupAddressContacts = new Contacts();
				Address dropAddress = new Address();
				Contacts dropAddressContacts = new Contacts();
				List<OrderDetailGroup> orders = new ArrayList<>();

				Dates dropDates = new Dates();
				Drop drop = new Drop();
				Pickup pickup = new Pickup();
				Dates pickupDates = new Dates();
				for (StopOffDetailGroup stopOffDetailGroup : detail.getStopOffDetailGroup()) {
					if("CL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) || 
							"PL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) || 
							"LD".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode())) {
						Event pickupEvent = new Event();
						pickupEvent.setType("Pickup");
						pickupEvent.setSequenceNum(String.valueOf(eventCount));

						Dates dates = new Dates();
						stopOffDetailGroup.getDateReference().forEach(d -> {
							Date date = new Date();

							if ("37".equalsIgnoreCase(d.getDateQualifier()) || "10".equalsIgnoreCase(d.getDateQualifier())) {
								LOG.info("Ear;liest Date: {}", d.getDate());
								date.setType("earliest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							} else if ("38".equalsIgnoreCase(d.getDateQualifier())) {
								LOG.info("Latest Date: {}", d.getDate());
								date.setType("latest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							}
							pickup.getDate().add(date);
							dates.getDate().add(date);
							pickupEvent.setDates(dates);
						});
						pickupDates.setPickup(pickup);
						
						Shipments shipments = new Shipments();

						ReferenceNumbers pickupReferenceNumbers = new ReferenceNumbers();
						ReferenceNumber refNumber = new ReferenceNumber();
						refNumber.setIsPrimary("true");
						refNumber.setType("BOL");
						refNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
						pickupReferenceNumbers.getReferenceNumber().add(refNumber);

						shipments.setReferenceNumbers(pickupReferenceNumbers);
						pickupEvent.setShipments(shipments);

						events.getEvent().add(pickupEvent);
						orders = (List<OrderDetailGroup>) stopOffDetailGroup.getOrderDetailGroup();
						
						for (StopOffDetailContactGroup stopOffDetailContactGroup : stopOffDetailGroup.getStopOffDetailContactGroup()) {
							if ("SF".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode()) ||
									"SH".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode())) {
								pickupAddress.setType("");
								pickupAddress.setIsResidential(Boolean.FALSE);
								pickupAddress.setLocationCode(stopOffDetailContactGroup.getName().getIdentificationCode());
								pickupAddress.setName(stopOffDetailContactGroup.getName().getName());
								pickupAddress
										.setAddrLine1(stopOffDetailContactGroup.getAddressInformation().getAddressLine1());
								pickupAddress
										.setAddrLine2(stopOffDetailContactGroup.getAddressInformation().getAddressLine2());
								pickupAddress.setCity(stopOffDetailContactGroup.getGeographicLocation().getCityName());
								pickupAddress.setStateProvince(
										stopOffDetailContactGroup.getGeographicLocation().getStateOrProvinceCode());
								pickupAddress
										.setPostalCode(stopOffDetailContactGroup.getGeographicLocation().getPostalCode());
								pickupAddress
										.setCountryCode(stopOffDetailContactGroup.getGeographicLocation().getCountryCode());

								int count = 1;

								ContactMethods contactMethods = new ContactMethods();
								Contact contact = new Contact();
								for (PersonContact c : stopOffDetailContactGroup.getPersonContact()) {
									contact.setName(c.getName());

									ContactMethod contactMethod = new ContactMethod();
									contactMethod.setSequenceNum(String.valueOf(count));
									switch (c.getCommunicationNumberQualifier()) {
									case "TE" -> contactMethod.setType("Phone");
									case "EM" -> contactMethod.setType("Email");
									default -> throw new IllegalArgumentException(
											"Unexpected value: " + c.getCommunicationNumberQualifier());
									}

									contactMethod.setValue(c.getCommunicationNumber());
									contactMethods.getContactMethod().add(contactMethod);

									count++;
								}
								contact.setContactMethods(contactMethods);
								pickupAddressContacts.setContact(contact);
								pickupAddress.getContacts().add(pickupAddressContacts);

								pickupEvent.setAddress(pickupAddress);
							} 
						}
					}else if("CU".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) ||
								"PU".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) ||
								"UL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode())) {
						Event dropEvent = new Event();
						dropEvent.setType("Drop");
						dropEvent.setSequenceNum(String.valueOf(eventCount));

						Dates dates = new Dates();
						stopOffDetailGroup.getDateReference().forEach(d -> {
							Date date = new Date();
							if ("02".equalsIgnoreCase(d.getDateQualifier()) || "53".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("earliest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							} else if ("38".equalsIgnoreCase(d.getDateQualifier()) || "54".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("latest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							}
							drop.getDate().add(date);
							dates.getDate().add(date);
							dropEvent.setDates(dates);
						});
						dropDates.setDrop(drop);
						
						Shipments shipments = new Shipments();
						ReferenceNumbers dropReferenceNumbers = new ReferenceNumbers();
						ReferenceNumber refNumber = new ReferenceNumber();
						refNumber.setIsPrimary("true");
						refNumber.setType("BOL");
						refNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
						dropReferenceNumbers.getReferenceNumber().add(refNumber);
						shipments.setReferenceNumbers(dropReferenceNumbers);
						dropEvent.setShipments(shipments);

						shipments.setReferenceNumbers(dropReferenceNumbers);
						dropEvent.setShipments(shipments);

						events.getEvent().add(dropEvent);
						
						for (StopOffDetailContactGroup stopOffDetailContactGroup : stopOffDetailGroup
								.getStopOffDetailContactGroup()) {
							if ("CN".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode()) ||
									"ST".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode())) {
								dropAddress.setType("");
								dropAddress.setIsResidential(Boolean.FALSE);
								dropAddress.setLocationCode(stopOffDetailContactGroup.getName().getIdentificationCode());
								dropAddress.setName(stopOffDetailContactGroup.getName().getName());
								dropAddress.setAddrLine1(stopOffDetailContactGroup.getAddressInformation().getAddressLine1());
								dropAddress.setAddrLine2(stopOffDetailContactGroup.getAddressInformation().getAddressLine2());
								dropAddress.setCity(stopOffDetailContactGroup.getGeographicLocation().getCityName());
								dropAddress.setStateProvince(stopOffDetailContactGroup.getGeographicLocation().getStateOrProvinceCode());
								dropAddress.setPostalCode(stopOffDetailContactGroup.getGeographicLocation().getPostalCode());
								dropAddress.setCountryCode(stopOffDetailContactGroup.getGeographicLocation().getCountryCode());

								int count = 1;
								ContactMethods contactMethods = new ContactMethods();
								Contact contact = new Contact();
								for (PersonContact c : stopOffDetailContactGroup.getPersonContact()) {
									
									contact.setName(c.getName());

									ContactMethod contactMethod = new ContactMethod();
									contactMethod.setSequenceNum(String.valueOf(count));
									switch (c.getCommunicationNumberQualifier()) {
									case "TE" -> contactMethod.setType("Phone");
									case "EM" -> contactMethod.setType("Email");
									default -> throw new IllegalArgumentException(
											"Unexpected value: " + c.getCommunicationNumberQualifier());
									}

									contactMethod.setValue(c.getCommunicationNumber());
									contactMethods.getContactMethod().add(contactMethod);

									count++;
								}
								
								contact.setContactMethods(contactMethods);
								dropAddressContacts.setContact(contact);
								dropAddress.getContacts().add(dropAddressContacts);

								dropEvent.setAddress(dropAddress);
							}
						}
					}
					eventCount++;
				}

				events.setCount(String.valueOf(events.getEvent().size()));
				plan.setEvents(events);
				load.setPlan(plan);

				PriceSheets priceSheets = new PriceSheets();
				PriceSheet priceSheet = new PriceSheet();
				priceSheet.setType("Cost");
				priceSheet.setIsSelected("true");
				priceSheet.setCurrencyCode("USD");
				priceSheet.setAccessorialTotal("0.00");
				if (null != trailer.getTotalWeightAndChargeSummary().getCharge()) {
					priceSheet.setSubTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					priceSheet.setTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					NormalizedTotal normalizedTotal = new NormalizedTotal();
					normalizedTotal.setCurrencyCode("USD");
					normalizedTotal
							.setValue(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					priceSheet.setNormalizedTotal(normalizedTotal);
				}else if(null != trailer.getTotalWeightAndChargeSummary() && null != trailer.getTotalWeightAndChargeSummary().getFreight()) {
					priceSheet.setSubTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getFreight()));
					priceSheet.setTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getFreight()));
				}else {
					priceSheet.setSubTotal("0.0");
					priceSheet.setTotal("0.0");
				}

				Carrier carrier = new Carrier();
				carrier.setCarrierId("EVANMN");
				carrier.setCarrierName("EVANS MINNEAPOLIS");
				carrier.setSCAC("EVMN");
				carrier.setMode("TL");
				carrier.setService("Standard");
				carrier.setServiceDays(BigDecimal.valueOf(0.0));
				carrier.setDistance(BigDecimal.valueOf(0.0));
				carrier.setId("EVANMN");

				Insurance cargoInsurance = new Insurance();
				cargoInsurance.setType("Cargo");
				cargoInsurance.setAmount(BigDecimal.valueOf(100000, 2));
				cargoInsurance.setCompany("");
				cargoInsurance.setExpirationDate("07/18/2099 00:00");
				cargoInsurance.setContactName("");
				cargoInsurance.setContactPhone("");

				Insurance generalInsurance = new Insurance();
				generalInsurance.setType("General");
				generalInsurance.setAmount(BigDecimal.valueOf(0, 2));
				generalInsurance.setCompany("");
				generalInsurance.setExpirationDate("07/18/2099 00:00");
				generalInsurance.setContactName("");
				generalInsurance.setContactPhone("");

				Insurance liabilityInsurance = new Insurance();
				liabilityInsurance.setType("Liability");
				liabilityInsurance.setAmount(BigDecimal.valueOf(1000000, 2));
				liabilityInsurance.setCompany("");
				liabilityInsurance.setExpirationDate("07/18/2099 00:00");
				liabilityInsurance.setContactName("");
				liabilityInsurance.setContactPhone("");

				PriceSheet.Carrier.InsuranceTypes insuranceTypes = new InsuranceTypes();
				insuranceTypes.getInsurance().add(cargoInsurance);
				insuranceTypes.getInsurance().add(generalInsurance);
				insuranceTypes.getInsurance().add(liabilityInsurance);

				carrier.setInsuranceTypes(insuranceTypes);

				priceSheet.setCarrier(carrier);
				
				Charges charges = new Charges();
				Charge charge = new Charge();
				charge.setSequence(BigInteger.valueOf(1));
				charge.setType("ITEM");
				charge.setDescription("Total Line Haul");
				if(null != trailer.getTotalWeightAndChargeSummary() && null != trailer.getTotalWeightAndChargeSummary().getFreight()) {
					charge.setAmount(trailer.getTotalWeightAndChargeSummary().getFreight());
					charge.setRate(trailer.getTotalWeightAndChargeSummary().getFreight());
				}else {
					charge.setAmount(BigDecimal.valueOf(0.0));
					charge.setRate(BigDecimal.valueOf(0.0));
				}
				
				charge.setRateQualifier("FR");
				charge.setQuantity(null);
				charge.setWeight(trailer.getTotalWeightAndChargeSummary().getWeight());
				charge.setFreightClass(BigDecimal.valueOf(0.0));
				
				charges.getCharge().add(charge);
				priceSheet.setCharges(charges);
				
				priceSheets.getPriceSheet().add(priceSheet);
				
				//Price Sheet "Charge"
				PriceSheet priceSheetCharge = new PriceSheet();
				priceSheetCharge.setType("Charge");
				priceSheetCharge.setIsSelected("true");
				priceSheetCharge.setCurrencyCode("USD");
				priceSheetCharge.setAccessorialTotal("0.00");
				priceSheetCharge.setSubTotal("0.01");
				priceSheetCharge.setTotal("0.01");
				NormalizedTotal normalizedTotal = new NormalizedTotal();
				normalizedTotal.setCurrencyCode("USD");
				normalizedTotal.setValue(String.valueOf("0.01"));
				priceSheetCharge.setNormalizedTotal(normalizedTotal);

				priceSheetCharge.setCarrier(carrier);
				
				Charges chCharges = new Charges();
				Charge chCharge = new Charge();
				chCharge.setSequence(BigInteger.valueOf(1));
				chCharge.setType("ITEM");
				chCharge.setDescription("Total Line Haul");
				chCharge.setAmount(BigDecimal.valueOf(0.01));
				chCharge.setRate(BigDecimal.valueOf(0.01));
				chCharge.setRateQualifier("FR");
				chCharge.setQuantity(null);
				chCharge.setWeight(BigDecimal.valueOf(0.0));
				chCharge.setFreightClass(BigDecimal.valueOf(0.0));
				
				chCharges.getCharge().add(chCharge);
				
				priceSheetCharge.setCharges(chCharges);

				priceSheets.getPriceSheet().add(priceSheetCharge);
				//Price Sheet "Charge"
				
				Shipments shipments = new Shipments();
				com.dc.evans.schema.mercurygate.Shipment mgShipments = new com.dc.evans.schema.mercurygate.Shipment();
				mgShipments.setType("Logistics");
				mgShipments.setAction("UpdateOrAdd");
				mgShipments.setStatus("Pending");
				mgShipments.setEnterprise(enterprise);
				Dates dates = new Dates();
				dates.setDrop(drop);
				dates.setPickup(pickup);
				mgShipments.setDates(dates);
				mgShipments.setReferenceNumbers(referenceNumbers);
				ServiceList serviceList = new ServiceList();
				serviceList.setServiceCode("GPS");
				mgShipments.setServiceList(serviceList);

				Dimensions dimensions = new Dimensions();
				Dimension dimension = new Dimension();
				dimension.setValue("1");
				dimension.setType("RatingCount");
				dimensions.getDimension().add(dimension);
				mgShipments.setDimensions(dimensions);

				Shipper shipper = new Shipper();
				shipper.setAddress(pickupAddress);
				mgShipments.setShipper(shipper);

				Consignee consignee = new Consignee();
				consignee.setAddress(dropAddress);
				mgShipments.setConsignee(consignee);
				
				header.getShippingBillingGroup().forEach(billing -> {
					switch (billing.getName().getEntityIdentifierCode()) {
					case "BT" -> {
						Payment billToPayment = new Payment();
						billToPayment.setMethod(payment.getMethod());

						TypeLocationEnvelope prepaid = new TypeLocationEnvelope();

						Address address = new Address();
						address.setLocationCode(billing.getName().getIdentificationCode());
						address.setType("Bill To");
						address.setIsResidential(Boolean.FALSE);
						address.setName(billing.getName().getName()); 
						address.setAddrLine1(billing.getAddressInformation().getAddressLine1());
						address.setAddrLine2(billing.getAddressInformation().getAddressLine2());
						address.setCity(billing.getGeographicLocation().getCityName());
						address.setStateProvince(billing.getGeographicLocation().getStateOrProvinceCode());
						address.setPostalCode(billing.getGeographicLocation().getPostalCode());
						address.setCountryCode(billing.getGeographicLocation().getCountryCode());
						if(null != billing.getContact()) {
							Contacts contacts = new Contacts();
							Contact contact = new Contact();
							contact.setName(billing.getContact().getName());

							contacts.setContact(contact);
							address.getContacts().add(contacts);
						}
						
						prepaid.setAddress(address);

						prepaid.setThirdParty("false");
						billToPayment.setBillTo(prepaid);
						mgShipments.setPayment(billToPayment);
					}
					}
				});

				ItemGroups itemGroups = new ItemGroups();

				orders.forEach(order -> {
					int count = 1;
					for (LadingDetailGroup items : order.getLadingDetailGroup()) {
						ItemGroup itemGroup = new ItemGroup();
						itemGroup.setId(String.valueOf(count));
						itemGroup.setIsShipUnit(Boolean.FALSE);
						itemGroup.setIsHandlingUnit(Boolean.FALSE);
						itemGroup.setSequence(String.valueOf(count));

						LineItem lineItem = new LineItem();
						lineItem.setLineNumber(String.valueOf(count));
						itemGroup.setLineItem(lineItem);
						itemGroup.setDescription(StringUtils.isNotBlank(items.getLadingDescription().getLadingDescription())?items.getLadingDescription().getLadingDescription():"ITEM DESCRIPTION N/A");
						FreightClasses freightClasses = new FreightClasses();
						FreightClass freightClass = new FreightClass();
						freightClass.setValue("70");
						freightClass.setType("");
						freightClasses.getFreightClass().add(freightClass);
						itemGroup.setFreightClasses(freightClasses);

						itemGroup.setNmfcCode("80865");
						itemGroup.setStackability(BigInteger.valueOf(0));
						Weights weights = new Weights();
						Quantities quantities = new Quantities();
						for (ShipmentWeightAndQuantityDetailGroup shipmentWeight : items
								.getShipmentWeightAndQuantityDetailGroup()) {
							Weight weight = new Weight();
							weight.setType("actual");
							weight.setUom("lbs");
							weight.setValue(
									shipmentWeight.getShipmentWeightAndQuantityDetails().getWeight().toPlainString());
							weights.getWeight().add(weight);

							if(null != shipmentWeight.getShipmentWeightAndQuantityDetails().getLadingQuantity()) {
								Quantity quantity = new Quantity();
								quantity.setType("actual");
								quantity.setUom("PCS");
								quantity.setValue(shipmentWeight.getShipmentWeightAndQuantityDetails().getLadingQuantity()
										.toString());
								quantities.getQuantity().add(quantity);
							}
						}

						itemGroup.setWeights(weights);
						itemGroup.setQuantities(quantities);
						itemGroups.getItemGroup().add(itemGroup);
					}

				});

				mgShipments.setItemGroups(itemGroups);
				mgShipments.setPriceSheets(priceSheets);
				shipments.getShipment().add(mgShipments);
				load.setPriceSheets(priceSheets);
				load.setShipments(shipments);
				mgShipment.setLoad(load);

				webImportFile.setMercuryGate(mgShipment);

				// Create JAXB context
				JAXBContext context = JAXBContext.newInstance(ServiceRequest.class);

				// Create marshaller
				Marshaller marshaller = context.createMarshaller();

				// Set property to format the XML
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				// Marshal the object to a StringWriter
				StringWriter sw = new StringWriter();
				marshaller.marshal(serviceRequest, sw);

				// Convert the StringWriter to a string
				String xmlString = sw.toString();

				// Output the XML string
				System.out.println(xmlString);

				Map<String, String> headers = new HashMap<>();
				headers.put("Authorization", mercuryGateAuth);
				headers.put("Content-Type", "application/xml");
				HttpResponse<String> response = HttpClientUtil.sendHttpRequest(HttpProtocol.POST, mercuryGateEndpoint, headers, xmlString);
				LOG.info("API Response: {}",response.body());
				if(response.statusCode() > 299) {
					mailService.sendErrorEmail(fileProcessEmailTo.split(","), "Error while sending XML to MercuryGate", 
							"Error while sending XML to MercuryGate \n\nError Stack: "+ response.body() + "\n\nXML Payload:"+ xmlString);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public void generateMercuryGateXML(com.dc.evans.edi.model.x12.edi204.v5010.Shipment shipment) throws Exception {

		// Define the desired date format
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
		for (IEDIMessageBody<com.dc.evans.edi.model.x12.edi204.v5010.ShipmentBody> body : shipment.getBody()) {
			try {
				com.dc.evans.edi.model.x12.edi204.v5010.Header header = (com.dc.evans.edi.model.x12.edi204.v5010.Header) body.getHeader();
				com.dc.evans.edi.model.x12.edi204.v5010.Detail detail = (com.dc.evans.edi.model.x12.edi204.v5010.Detail) body.getDetail();
				com.dc.evans.edi.model.x12.edi204.v5010.Trailer trailer = (com.dc.evans.edi.model.x12.edi204.v5010.Trailer) body.getTrailer();

				// Create an instance of your object
				ServiceRequest serviceRequest = new ServiceRequest();
				serviceRequest.setServiceId("ImportWeb");
				serviceRequest.setRequestId(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
				Data data = new Data();
				WebImport webImport = new WebImport();
				ServiceRequest.Data.WebImport.WebImportFile webImportFile = new WebImportFile();
				
				webImport.setWebImportFile(webImportFile);
				ServiceRequest.Data.WebImport.WebImportHeader webImportHeader = new WebImportHeader();
				webImportHeader.setType("WebImportTransportManualRate");
				webImportHeader.setUserName("WebserviceUserEatonEDI");
				webImportHeader.setFileName(header.getBeginningSegmentforInvoice().getShipmentRefNumber()+".xml");
				webImport.setWebImportHeader(webImportHeader);
				data.setWebImport(webImport);
				serviceRequest.setData(data);
				MercuryGate mgShipment = new MercuryGate();
				com.dc.evans.schema.mercurygate.Header mgHeader = new com.dc.evans.schema.mercurygate.Header();
				mgHeader.setDocCount("1");
				mgHeader.setDocTypeID("MasterBillofLading");
				mgShipment.setHeader(mgHeader);
				// Populate the object with data
				Load load = new Load();
				load.setAction("UpdateOrAdd");

				Enterprise enterprise = new Enterprise();
				enterprise.setCustomerAcctNum("EATONWA2");
				load.setEnterprise(enterprise);

				ReferenceNumbers referenceNumbers = new ReferenceNumbers();

				ReferenceNumber bolReferenceNumber = new ReferenceNumber();
				bolReferenceNumber.setType("BOL");
				bolReferenceNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
				bolReferenceNumber.setIsPrimary("true");
				referenceNumbers.getReferenceNumber().add(bolReferenceNumber);

				ReferenceNumber autoAcceptReferenceNumber = new ReferenceNumber();
				autoAcceptReferenceNumber.setType("Auto Accept");
				autoAcceptReferenceNumber.setValue("true");
				autoAcceptReferenceNumber.setIsPrimary("false");
				referenceNumbers.getReferenceNumber().add(autoAcceptReferenceNumber);

				header.getBusinessInstruction().forEach(req -> {
					if ("DLH".equalsIgnoreCase(req.getReferenceDescription())
							|| "FSF".equalsIgnoreCase(req.getReferenceDescription())) {
						ReferenceNumber referenceNumber = new ReferenceNumber();
						referenceNumber.setType(req.getReferenceDescription());
						referenceNumber.setValue(req.getReferenceIdentificationQualifier());
						referenceNumber.setIsPrimary("false");
						referenceNumbers.getReferenceNumber().add(referenceNumber);
					}
				});

				load.setReferenceNumbers(referenceNumbers);

				Payment payment = new Payment();
				switch (header.getBeginningSegmentforInvoice().getPaymentMethod()) {
				case "PP" -> {
					payment.setMethod("Prepaid");

					TypeLocationEnvelope prepaid = new TypeLocationEnvelope();

					Address address = new Address();
					address.setName("EVANS TRANSPORTATION");
					address.setAddrLine1("400 GENESEE STREET");
					address.setAddrLine2("SUITE 3F");
					address.setCity("DELAFIELD");
					address.setStateProvince("WI");
					address.setPostalCode("53018");
					address.setCountryCode("USA");
					prepaid.setAddress(address);

					prepaid.setThirdParty("false");
					payment.setBillTo(prepaid);
				}
				case "CC" -> payment.setMethod("Collect");
				case "TP" -> payment.setMethod("Third Party");
				default -> throw new IllegalArgumentException(
						"Unexpected value: " + header.getBeginningSegmentforInvoice().getPaymentMethod());
				}
				load.setPayment(payment);

				Plan plan = new Plan();

				Events events = new Events();

				int eventCount = 1;
				Address pickupAddress = new Address();
				Contacts pickupAddressContacts = new Contacts();
				Address dropAddress = new Address();
				Contacts dropAddressContacts = new Contacts();
				List<com.dc.evans.edi.model.x12.edi204.v5010.OrderDetailGroup> orders = new ArrayList<>();

				Dates dropDates = new Dates();
				Drop drop = new Drop();
				Pickup pickup = new Pickup();
				Dates pickupDates = new Dates();
				for (com.dc.evans.edi.model.x12.edi204.v5010.StopOffDetailGroup stopOffDetailGroup : detail.getStopOffDetailGroup()) {
					if("CL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) || 
							"PL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) || 
							"LD".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode())) {
						Event pickupEvent = new Event();
						pickupEvent.setType("Pickup");
						pickupEvent.setSequenceNum(String.valueOf(eventCount));

						Dates dates = new Dates();
						stopOffDetailGroup.getDateReference().forEach(d -> {
							Date date = new Date();

							if ("37".equalsIgnoreCase(d.getDateQualifier()) || "10".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("earliest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							} else if ("38".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("latest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							}
							pickup.getDate().add(date);
							dates.getDate().add(date);
							pickupEvent.setDates(dates);
						});
						pickupDates.setPickup(pickup);
						
						Shipments shipments = new Shipments();

						ReferenceNumbers pickupReferenceNumbers = new ReferenceNumbers();
						ReferenceNumber refNumber = new ReferenceNumber();
						refNumber.setIsPrimary("true");
						refNumber.setType("BOL");
						refNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
						pickupReferenceNumbers.getReferenceNumber().add(refNumber);

						shipments.setReferenceNumbers(pickupReferenceNumbers);
						pickupEvent.setShipments(shipments);

						events.getEvent().add(pickupEvent);
						orders = (List<com.dc.evans.edi.model.x12.edi204.v5010.OrderDetailGroup>) stopOffDetailGroup.getOrderDetailGroup();
						
						for (com.dc.evans.edi.model.x12.edi204.v5010.StopOffDetailContactGroup stopOffDetailContactGroup : stopOffDetailGroup.getStopOffDetailContactGroup()) {
							if ("SF".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode()) ||
									"SH".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode())) {
								pickupAddress.setType("");
								pickupAddress.setIsResidential(Boolean.FALSE);
								pickupAddress.setLocationCode(stopOffDetailContactGroup.getName().getIdentificationCode());
								pickupAddress.setName(stopOffDetailContactGroup.getName().getName());
								pickupAddress
										.setAddrLine1(stopOffDetailContactGroup.getAddressInformation().getAddressLine1());
								pickupAddress
										.setAddrLine2(stopOffDetailContactGroup.getAddressInformation().getAddressLine2());
								pickupAddress.setCity(stopOffDetailContactGroup.getGeographicLocation().getCityName());
								pickupAddress.setStateProvince(
										stopOffDetailContactGroup.getGeographicLocation().getStateOrProvinceCode());
								pickupAddress
										.setPostalCode(stopOffDetailContactGroup.getGeographicLocation().getPostalCode());
								pickupAddress
										.setCountryCode(stopOffDetailContactGroup.getGeographicLocation().getCountryCode());

								int count = 1;

								ContactMethods contactMethods = new ContactMethods();
								Contact contact = new Contact();
								for (PersonContact c : stopOffDetailContactGroup.getPersonContact()) {
									contact.setName(c.getName());

									ContactMethod contactMethod = new ContactMethod();
									contactMethod.setSequenceNum(String.valueOf(count));
									switch (c.getCommunicationNumberQualifier()) {
									case "TE" -> contactMethod.setType("Phone");
									case "EM" -> contactMethod.setType("Email");
									default -> throw new IllegalArgumentException(
											"Unexpected value: " + c.getCommunicationNumberQualifier());
									}

									contactMethod.setValue(c.getCommunicationNumber());
									contactMethods.getContactMethod().add(contactMethod);

									count++;
								}
								contact.setContactMethods(contactMethods);
								pickupAddressContacts.setContact(contact);
								pickupAddress.getContacts().add(pickupAddressContacts);

								pickupEvent.setAddress(pickupAddress);
							} 
						}
					}else if("CU".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) ||
								"PU".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode()) ||
								"UL".equalsIgnoreCase(stopOffDetailGroup.getStopOffDetail().getStopReasonCode())) {
						Event dropEvent = new Event();
						dropEvent.setType("Drop");
						dropEvent.setSequenceNum(String.valueOf(eventCount));

						Dates dates = new Dates();
						stopOffDetailGroup.getDateReference().forEach(d -> {
							Date date = new Date();
							if ("02".equalsIgnoreCase(d.getDateQualifier()) || "53".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("earliest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							} else if ("38".equalsIgnoreCase(d.getDateQualifier()) || "54".equalsIgnoreCase(d.getDateQualifier())) {
								date.setType("latest");
								date.setValue(sdf.format(d.getDate())
										+ " " + parseFlexibleTime(d.getTime()));
							}
							drop.getDate().add(date);
							dates.getDate().add(date);
							dropEvent.setDates(dates);
						});
						dropDates.setDrop(drop);
						
						Shipments shipments = new Shipments();
						ReferenceNumbers dropReferenceNumbers = new ReferenceNumbers();
						ReferenceNumber refNumber = new ReferenceNumber();
						refNumber.setIsPrimary("true");
						refNumber.setType("BOL");
						refNumber.setValue(header.getBeginningSegmentforInvoice().getShipmentRefNumber());
						dropReferenceNumbers.getReferenceNumber().add(refNumber);
						shipments.setReferenceNumbers(dropReferenceNumbers);
						dropEvent.setShipments(shipments);

						shipments.setReferenceNumbers(dropReferenceNumbers);
						dropEvent.setShipments(shipments);

						events.getEvent().add(dropEvent);
						
						for (com.dc.evans.edi.model.x12.edi204.v5010.StopOffDetailContactGroup stopOffDetailContactGroup : stopOffDetailGroup
								.getStopOffDetailContactGroup()) {
							if ("CN".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode()) ||
									"ST".equalsIgnoreCase(stopOffDetailContactGroup.getName().getEntityIdentifierCode())) {
								dropAddress.setType("");
								dropAddress.setIsResidential(Boolean.FALSE);
								dropAddress.setLocationCode(stopOffDetailContactGroup.getName().getIdentificationCode());
								dropAddress.setName(stopOffDetailContactGroup.getName().getName());
								dropAddress.setAddrLine1(stopOffDetailContactGroup.getAddressInformation().getAddressLine1());
								dropAddress.setAddrLine2(stopOffDetailContactGroup.getAddressInformation().getAddressLine2());
								dropAddress.setCity(stopOffDetailContactGroup.getGeographicLocation().getCityName());
								dropAddress.setStateProvince(stopOffDetailContactGroup.getGeographicLocation().getStateOrProvinceCode());
								dropAddress.setPostalCode(stopOffDetailContactGroup.getGeographicLocation().getPostalCode());
								dropAddress.setCountryCode(stopOffDetailContactGroup.getGeographicLocation().getCountryCode());

								int count = 1;
								ContactMethods contactMethods = new ContactMethods();
								Contact contact = new Contact();
								for (PersonContact c : stopOffDetailContactGroup.getPersonContact()) {
									
									contact.setName(c.getName());

									ContactMethod contactMethod = new ContactMethod();
									contactMethod.setSequenceNum(String.valueOf(count));
									switch (c.getCommunicationNumberQualifier()) {
									case "TE" -> contactMethod.setType("Phone");
									case "EM" -> contactMethod.setType("Email");
									default -> throw new IllegalArgumentException(
											"Unexpected value: " + c.getCommunicationNumberQualifier());
									}

									contactMethod.setValue(c.getCommunicationNumber());
									contactMethods.getContactMethod().add(contactMethod);

									count++;
								}
								
								contact.setContactMethods(contactMethods);
								dropAddressContacts.setContact(contact);
								dropAddress.getContacts().add(dropAddressContacts);

								dropEvent.setAddress(dropAddress);
							}
						}
					}
					eventCount++;
				}

				events.setCount(String.valueOf(events.getEvent().size()));
				plan.setEvents(events);
				load.setPlan(plan);

				PriceSheets priceSheets = new PriceSheets();
				PriceSheet priceSheet = new PriceSheet();
				priceSheet.setType("Cost");
				priceSheet.setIsSelected("true");
				priceSheet.setCurrencyCode("USD");
				priceSheet.setAccessorialTotal("0.00");
				if (null != trailer.getTotalWeightAndChargeSummary().getCharge()) {
					priceSheet.setSubTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					priceSheet.setTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					NormalizedTotal normalizedTotal = new NormalizedTotal();
					normalizedTotal.setCurrencyCode("USD");
					normalizedTotal
							.setValue(String.valueOf(trailer.getTotalWeightAndChargeSummary().getCharge() / 100));
					priceSheet.setNormalizedTotal(normalizedTotal);
				}else if(null != trailer.getTotalWeightAndChargeSummary() && null != trailer.getTotalWeightAndChargeSummary().getFreight()) {
					priceSheet.setSubTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getFreight()));
					priceSheet.setTotal(String.valueOf(trailer.getTotalWeightAndChargeSummary().getFreight()));
				}else {
					priceSheet.setSubTotal("0.0");
					priceSheet.setTotal("0.0");
				}

				Carrier carrier = new Carrier();
				carrier.setCarrierId("EVANMN");
				carrier.setCarrierName("EVANS MINNEAPOLIS");
				carrier.setSCAC("EVMN");
				carrier.setMode("TL");
				carrier.setService("Standard");
				carrier.setServiceDays(BigDecimal.valueOf(0.0));
				carrier.setDistance(BigDecimal.valueOf(0.0));
				carrier.setId("EVANMN");

				Insurance cargoInsurance = new Insurance();
				cargoInsurance.setType("Cargo");
				cargoInsurance.setAmount(BigDecimal.valueOf(100000, 2));
				cargoInsurance.setCompany("");
				cargoInsurance.setExpirationDate("07/18/2099 00:00");
				cargoInsurance.setContactName("");
				cargoInsurance.setContactPhone("");

				Insurance generalInsurance = new Insurance();
				generalInsurance.setType("General");
				generalInsurance.setAmount(BigDecimal.valueOf(0, 2));
				generalInsurance.setCompany("");
				generalInsurance.setExpirationDate("07/18/2099 00:00");
				generalInsurance.setContactName("");
				generalInsurance.setContactPhone("");

				Insurance liabilityInsurance = new Insurance();
				liabilityInsurance.setType("Liability");
				liabilityInsurance.setAmount(BigDecimal.valueOf(1000000, 2));
				liabilityInsurance.setCompany("");
				liabilityInsurance.setExpirationDate("07/18/2099 00:00");
				liabilityInsurance.setContactName("");
				liabilityInsurance.setContactPhone("");

				PriceSheet.Carrier.InsuranceTypes insuranceTypes = new InsuranceTypes();
				insuranceTypes.getInsurance().add(cargoInsurance);
				insuranceTypes.getInsurance().add(generalInsurance);
				insuranceTypes.getInsurance().add(liabilityInsurance);

				carrier.setInsuranceTypes(insuranceTypes);

				priceSheet.setCarrier(carrier);
				
				Charges charges = new Charges();
				Charge charge = new Charge();
				charge.setSequence(BigInteger.valueOf(1));
				charge.setType("ITEM");
				charge.setDescription("Total Line Haul");
				if(null != trailer.getTotalWeightAndChargeSummary() && null != trailer.getTotalWeightAndChargeSummary().getFreight()) {
					charge.setAmount(trailer.getTotalWeightAndChargeSummary().getFreight());
					charge.setRate(trailer.getTotalWeightAndChargeSummary().getFreight());
				}else {
					charge.setAmount(BigDecimal.valueOf(0.0));
					charge.setRate(BigDecimal.valueOf(0.0));
				}
				
				charge.setRateQualifier("FR");
				charge.setQuantity(null);
				charge.setWeight(trailer.getTotalWeightAndChargeSummary().getWeight());
				charge.setFreightClass(BigDecimal.valueOf(0.0));
				
				charges.getCharge().add(charge);
				priceSheet.setCharges(charges);
				
				priceSheets.getPriceSheet().add(priceSheet);
				
				//Price Sheet "Charge"
				PriceSheet priceSheetCharge = new PriceSheet();
				priceSheetCharge.setType("Charge");
				priceSheetCharge.setIsSelected("true");
				priceSheetCharge.setCurrencyCode("USD");
				priceSheetCharge.setAccessorialTotal("0.00");
				priceSheetCharge.setSubTotal("0.01");
				priceSheetCharge.setTotal("0.01");
				NormalizedTotal normalizedTotal = new NormalizedTotal();
				normalizedTotal.setCurrencyCode("USD");
				normalizedTotal.setValue(String.valueOf("0.01"));
				priceSheetCharge.setNormalizedTotal(normalizedTotal);

				priceSheetCharge.setCarrier(carrier);
				
				Charges chCharges = new Charges();
				Charge chCharge = new Charge();
				chCharge.setSequence(BigInteger.valueOf(1));
				chCharge.setType("ITEM");
				chCharge.setDescription("Total Line Haul");
				chCharge.setAmount(BigDecimal.valueOf(0.01));
				chCharge.setRate(BigDecimal.valueOf(0.01));
				chCharge.setRateQualifier("FR");
				chCharge.setQuantity(null);
				chCharge.setWeight(BigDecimal.valueOf(0.0));
				chCharge.setFreightClass(BigDecimal.valueOf(0.0));
				
				chCharges.getCharge().add(chCharge);
				
				priceSheetCharge.setCharges(chCharges);

				priceSheets.getPriceSheet().add(priceSheetCharge);
				//Price Sheet "Charge"
				
				Shipments shipments = new Shipments();
				com.dc.evans.schema.mercurygate.Shipment mgShipments = new com.dc.evans.schema.mercurygate.Shipment();
				mgShipments.setType("Logistics");
				mgShipments.setAction("UpdateOrAdd");
				mgShipments.setStatus("Pending");
				mgShipments.setEnterprise(enterprise);
				Dates dates = new Dates();
				dates.setDrop(drop);
				dates.setPickup(pickup);
				mgShipments.setDates(dates);
				mgShipments.setReferenceNumbers(referenceNumbers);
				ServiceList serviceList = new ServiceList();
				serviceList.setServiceCode("GPS");
				mgShipments.setServiceList(serviceList);

				Dimensions dimensions = new Dimensions();
				Dimension dimension = new Dimension();
				dimension.setValue("1");
				dimension.setType("RatingCount");
				dimensions.getDimension().add(dimension);
				mgShipments.setDimensions(dimensions);

				Shipper shipper = new Shipper();
				shipper.setAddress(pickupAddress);
				mgShipments.setShipper(shipper);

				Consignee consignee = new Consignee();
				consignee.setAddress(dropAddress);
				mgShipments.setConsignee(consignee);
				
				header.getShippingBillingGroup().forEach(billing -> {
					switch (billing.getName().getEntityIdentifierCode()) {
					case "BT" -> {
						Payment billToPayment = new Payment();
						billToPayment.setMethod(payment.getMethod());

						TypeLocationEnvelope prepaid = new TypeLocationEnvelope();

						Address address = new Address();
						address.setLocationCode(billing.getName().getIdentificationCode());
						address.setType("Bill To");
						address.setIsResidential(Boolean.FALSE);
						address.setName(billing.getName().getName()); 
						address.setAddrLine1(billing.getAddressInformation().getAddressLine1());
						address.setAddrLine2(billing.getAddressInformation().getAddressLine2());
						address.setCity(billing.getGeographicLocation().getCityName());
						address.setStateProvince(billing.getGeographicLocation().getStateOrProvinceCode());
						address.setPostalCode(billing.getGeographicLocation().getPostalCode());
						address.setCountryCode(billing.getGeographicLocation().getCountryCode());
						if(null != billing.getContact()) {
							Contacts contacts = new Contacts();
							Contact contact = new Contact();
							contact.setName(billing.getContact().getName());

							contacts.setContact(contact);
							address.getContacts().add(contacts);
						}
						
						prepaid.setAddress(address);

						prepaid.setThirdParty("false");
						billToPayment.setBillTo(prepaid);
						mgShipments.setPayment(billToPayment);
					}
					}
				});

				ItemGroups itemGroups = new ItemGroups();

				orders.forEach(order -> {
					int count = 1;
					for (com.dc.evans.edi.model.x12.edi204.v5010.LadingDetailGroup items : order.getLadingDetailGroup()) {
						ItemGroup itemGroup = new ItemGroup();
						itemGroup.setId(String.valueOf(count));
						itemGroup.setIsShipUnit(Boolean.FALSE);
						itemGroup.setIsHandlingUnit(Boolean.FALSE);
						itemGroup.setSequence(String.valueOf(count));

						LineItem lineItem = new LineItem();
						lineItem.setLineNumber(String.valueOf(count));
						itemGroup.setLineItem(lineItem);
						itemGroup.setDescription(StringUtils.isNotBlank(items.getLadingDescription().getLadingDescription())?items.getLadingDescription().getLadingDescription():"ITEM DESCRIPTION N/A");
						FreightClasses freightClasses = new FreightClasses();
						FreightClass freightClass = new FreightClass();
						freightClass.setValue("70");
						freightClass.setType("");
						freightClasses.getFreightClass().add(freightClass);
						itemGroup.setFreightClasses(freightClasses);

						itemGroup.setNmfcCode("80865");
						itemGroup.setStackability(BigInteger.valueOf(0));
						Weights weights = new Weights();
						Quantities quantities = new Quantities();
						for (com.dc.evans.edi.model.x12.edi204.v5010.ShipmentWeightAndQuantityDetailGroup shipmentWeight : items
								.getShipmentWeightAndQuantityDetailGroup()) {
							Weight weight = new Weight();
							weight.setType("actual");
							weight.setUom("lbs");
							weight.setValue(
									shipmentWeight.getShipmentWeightAndQuantityDetails().getWeight().toPlainString());
							weights.getWeight().add(weight);

							if(null != shipmentWeight.getShipmentWeightAndQuantityDetails().getLadingQuantity()) {
								Quantity quantity = new Quantity();
								quantity.setType("actual");
								quantity.setUom("PCS");
								quantity.setValue(shipmentWeight.getShipmentWeightAndQuantityDetails().getLadingQuantity()
										.toString());
								quantities.getQuantity().add(quantity);
							}
						}

						itemGroup.setWeights(weights);
						itemGroup.setQuantities(quantities);
						itemGroups.getItemGroup().add(itemGroup);
					}

				});

				mgShipments.setItemGroups(itemGroups);
				mgShipments.setPriceSheets(priceSheets);
				shipments.getShipment().add(mgShipments);
				load.setPriceSheets(priceSheets);
				load.setShipments(shipments);
				mgShipment.setLoad(load);

				webImportFile.setMercuryGate(mgShipment);

				// Create JAXB context
				JAXBContext context = JAXBContext.newInstance(ServiceRequest.class);

				// Create marshaller
				Marshaller marshaller = context.createMarshaller();

				// Set property to format the XML
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				// Marshal the object to a StringWriter
				StringWriter sw = new StringWriter();
				marshaller.marshal(serviceRequest, sw);

				// Convert the StringWriter to a string
				String xmlString = sw.toString();

				// Output the XML string
				System.out.println(xmlString);

				Map<String, String> headers = new HashMap<>();
				headers.put("Authorization", mercuryGateAuth);
				headers.put("Content-Type", "application/xml");
				HttpResponse<String> response = HttpClientUtil.sendHttpRequest(HttpProtocol.POST, mercuryGateEndpoint, headers, xmlString);
				LOG.info("API Response: {}",response.body());
				if(response.statusCode() > 299) {
					mailService.sendErrorEmail(fileProcessEmailTo.split(","), "Error while sending XML to MercuryGate", 
							"Error while sending XML to MercuryGate \n\nError Stack: "+ response.body() + "\n\nXML Payload:"+ xmlString);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	private static LocalTime parseFlexibleTime(String timeString) {
        DateTimeFormatter formatterWithSeconds = DateTimeFormatter.ofPattern("HHmmss",Locale.ENGLISH);
        DateTimeFormatter formatterWithoutSeconds = DateTimeFormatter.ofPattern("HHmm",Locale.ENGLISH);

        try {
            if (timeString.length() == 6) {
                return LocalTime.parse(timeString, formatterWithSeconds);
            } else if (timeString.length() == 4) {
                return LocalTime.parse(timeString, formatterWithoutSeconds);
            } else {
                throw new IllegalArgumentException("Unsupported time format: " + timeString);
            }
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Failed to parse time: " + timeString, e);
        }
    }
}
