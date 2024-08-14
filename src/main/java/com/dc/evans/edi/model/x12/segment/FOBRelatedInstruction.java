package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="FOB")
public class FOBRelatedInstruction {

	@EDIElement(fieldName="FOB01", dataElement="146")
	@NotNull
	@Size(min=2, max=2)
	private String shipmentMethodOfPayment;

	@EDIElement(fieldName="FOB02", dataElement="309")
	@Size(min=1, max=2)
	private String locationQualifier;

	@EDIElement(fieldName="FOB03", dataElement="352")
	@Size(min=1, max=80)
	private String description;

	@EDIElement(fieldName="FOB04", dataElement="334")
	@Size(min=1, max=2)
	private String transportationTermQualifier;

	@EDIElement(fieldName="FOB05", dataElement="335")
	@Size(min=3, max=3)
	private String transportationTermCode;

	@EDIElement(fieldName="FOB06", dataElement="309")
	@Size(min=1, max=2)
	private String locationQualifier2;

	@EDIElement(fieldName="FOB07", dataElement="352")
	@Size(min=1, max=80)
	private String description2;

	/**
	 * @return the shipmentMethodOfPayment
	 */
	public String getShipmentMethodOfPayment() {
		return shipmentMethodOfPayment;
	}

	/**
	 * @param shipmentMethodOfPayment the shipmentMethodOfPayment to set
	 */
	public void setShipmentMethodOfPayment(String shipmentMethodOfPayment) {
		this.shipmentMethodOfPayment = shipmentMethodOfPayment;
	}

	/**
	 * @return the locationQualifier
	 */
	public String getLocationQualifier() {
		return locationQualifier;
	}

	/**
	 * @param locationQualifier the locationQualifier to set
	 */
	public void setLocationQualifier(String locationQualifier) {
		this.locationQualifier = locationQualifier;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the transportationTermQualifier
	 */
	public String getTransportationTermQualifier() {
		return transportationTermQualifier;
	}

	/**
	 * @param transportationTermQualifier the transportationTermQualifier to set
	 */
	public void setTransportationTermQualifier(String transportationTermQualifier) {
		this.transportationTermQualifier = transportationTermQualifier;
	}

	/**
	 * @return the transportationTermCode
	 */
	public String getTransportationTermCode() {
		return transportationTermCode;
	}

	/**
	 * @param transportationTermCode the transportationTermCode to set
	 */
	public void setTransportationTermCode(String transportationTermCode) {
		this.transportationTermCode = transportationTermCode;
	}

	/**
	 * @return the locationQualifier2
	 */
	public String getLocationQualifier2() {
		return locationQualifier2;
	}

	/**
	 * @param locationQualifier2 the locationQualifier2 to set
	 */
	public void setLocationQualifier2(String locationQualifier2) {
		this.locationQualifier2 = locationQualifier2;
	}

	/**
	 * @return the description2
	 */
	public String getDescription2() {
		return description2;
	}

	/**
	 * @param description2 the description2 to set
	 */
	public void setDescription2(String description2) {
		this.description2 = description2;
	}



}
