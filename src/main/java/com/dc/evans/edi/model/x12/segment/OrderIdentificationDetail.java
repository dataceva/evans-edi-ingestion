package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="OID")
public class OrderIdentificationDetail {

	@EDIElement(fieldName="OID01", dataElement="127")
	private String referenceNumber;
	
	@EDIElement(fieldName="OID02", dataElement="324")
	private String orderNumber;

	@EDIElement(fieldName="OID03", dataElement="127")
	private String referenceNumber2;
	
	@EDIElement(fieldName="OID04", dataElement="355")
	private String quantityUOM;
	
	@EDIElement(fieldName="OID05", dataElement="380")
	private Integer quantity;
	
	@EDIElement(fieldName="OID06", dataElement="188")
	private String weightUOM;
	
	@EDIElement(fieldName="OID07", dataElement="81")
	private Double weight;
	
	@EDIElement(fieldName="OID08", dataElement="188")
	private String volumeUOM;
	
	@EDIElement(fieldName="OID09", dataElement="81")
	private String volume;

	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the quantityUOM
	 */
	public String getQuantityUOM() {
		return quantityUOM;
	}

	/**
	 * @param quantityUOM the quantityUOM to set
	 */
	public void setQuantityUOM(String quantityUOM) {
		this.quantityUOM = quantityUOM;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the volumeUOM
	 */
	public String getVolumeUOM() {
		return volumeUOM;
	}

	/**
	 * @param volumeUOM the volumeUOM to set
	 */
	public void setVolumeUOM(String volumeUOM) {
		this.volumeUOM = volumeUOM;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the referenceNumber2
	 */
	public String getReferenceNumber2() {
		return referenceNumber2;
	}

	/**
	 * @param referenceNumber2 the referenceNumber2 to set
	 */
	public void setReferenceNumber2(String referenceNumber2) {
		this.referenceNumber2 = referenceNumber2;
	}
}
