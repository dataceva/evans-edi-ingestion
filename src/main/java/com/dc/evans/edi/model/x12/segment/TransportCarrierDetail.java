package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="CAD")
public class TransportCarrierDetail {

	@EDIElement(fieldName="CAD01", dataElement="91")
	@Size(min=1,max=2)
	private String transportationMethod;
	
	@EDIElement(fieldName="CAD02", dataElement="206")
	@Size(min=1,max=4)
	private String equipmentInitial;
	
	@EDIElement(fieldName="CAD03", dataElement="207")
	@Size(min=1,max=10)
	private String equipmentNumber;
	
	@EDIElement(fieldName="CAD04", dataElement="140")
	@Size(min=2,max=4)
	private String carrierCode;
	
	@EDIElement(fieldName="CAD05", dataElement="387")
	@Size(min=1,max=35)
	private String routing;
	
	@EDIElement(fieldName="CAD06", dataElement="368")
	@Size(min=2,max=2)
	private String shipmentStatus;
	
	@EDIElement(fieldName="CAD07", dataElement="128")
	@Size(min=2,max=3)
	private String referenceQualifier;
	
	@EDIElement(fieldName="CAD08", dataElement="127")
	@Size(min=1,max=30)
	private String referenceIdentification;

	/**
	 * @return the transportationMethod
	 */
	public String getTransportationMethod() {
		return transportationMethod;
	}

	/**
	 * @param transportationMethod the transportationMethod to set
	 */
	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}

	/**
	 * @return the equipmentInitial
	 */
	public String getEquipmentInitial() {
		return equipmentInitial;
	}

	/**
	 * @param equipmentInitial the equipmentInitial to set
	 */
	public void setEquipmentInitial(String equipmentInitial) {
		this.equipmentInitial = equipmentInitial;
	}

	/**
	 * @return the equipmentNumber
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	/**
	 * @param equipmentNumber the equipmentNumber to set
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	/**
	 * @return the carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * @param carrierCode the carrierCode to set
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	/**
	 * @return the routing
	 */
	public String getRouting() {
		return routing;
	}

	/**
	 * @param routing the routing to set
	 */
	public void setRouting(String routing) {
		this.routing = routing;
	}

	/**
	 * @return the shipmentStatus
	 */
	public String getShipmentStatus() {
		return shipmentStatus;
	}

	/**
	 * @param shipmentStatus the shipmentStatus to set
	 */
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	/**
	 * @return the referenceQualifier
	 */
	public String getReferenceQualifier() {
		return referenceQualifier;
	}

	/**
	 * @param referenceQualifier the referenceQualifier to set
	 */
	public void setReferenceQualifier(String referenceQualifier) {
		this.referenceQualifier = referenceQualifier;
	}

	/**
	 * @return the referenceIdentification
	 */
	public String getReferenceIdentification() {
		return referenceIdentification;
	}

	/**
	 * @param referenceIdentification the referenceIdentification to set
	 */
	public void setReferenceIdentification(String referenceIdentification) {
		this.referenceIdentification = referenceIdentification;
	}

}
