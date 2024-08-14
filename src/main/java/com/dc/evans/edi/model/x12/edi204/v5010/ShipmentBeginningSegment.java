package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="B2")
public class ShipmentBeginningSegment {
	
	@EDIElement(fieldName="B201")
	@NotNull
	@Size(min=2, max=4)
	private String tariffServiceCode;
	
	@EDIElement(fieldName="B202")
	@NotNull
	@Size(min=2, max=4)
	private String carrierCode;
	
	@EDIElement(fieldName="B203")
	private String locationCode;
	
	@EDIElement(fieldName="B204")
	private String shipmentRefNumber;
	
	@EDIElement(fieldName="B205")
	private String weightUOM;
	
	@EDIElement(fieldName="B206")
	@Size(min=1, max=22)
	private String paymentMethod;

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
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * @return the shipmentRefNumber
	 */
	public String getShipmentRefNumber() {
		return shipmentRefNumber;
	}

	/**
	 * @param shipmentRefNumber the shipmentRefNumber to set
	 */
	public void setShipmentRefNumber(String shipmentRefNumber) {
		this.shipmentRefNumber = shipmentRefNumber;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the tariffServiceCode
	 */
	public String getTariffServiceCode() {
		return tariffServiceCode;
	}

	/**
	 * @param tariffServiceCode the tariffServiceCode to set
	 */
	public void setTariffServiceCode(String tariffServiceCode) {
		this.tariffServiceCode = tariffServiceCode;
	}

	/**
	 * @return the weightUOM
	 */
	public String getWeightUOM() {
		return weightUOM;
	}

	/**
	 * @param weightUOM the weightUOM to set
	 */
	public void setWeightUOM(String weightUOM) {
		this.weightUOM = weightUOM;
	}
}
