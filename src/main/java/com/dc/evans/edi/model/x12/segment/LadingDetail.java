package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="LAD")
public class LadingDetail {

	@EDIElement(fieldName="LAD03", dataElement="188")
	private String weightUOM;
	
	@EDIElement(fieldName="LAD04", dataElement="81")
	private Double weight;
	
	@EDIElement(fieldName="LAD07", dataElement="188")
	private String productServiceQualifier;
	
	@EDIElement(fieldName="LAD08", dataElement="81")
	private String productServiceId;

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
	 * @return the productServiceQualifier
	 */
	public String getProductServiceQualifier() {
		return productServiceQualifier;
	}

	/**
	 * @param productServiceQualifier the productServiceQualifier to set
	 */
	public void setProductServiceQualifier(String productServiceQualifier) {
		this.productServiceQualifier = productServiceQualifier;
	}

	/**
	 * @return the productServiceId
	 */
	public String getProductServiceId() {
		return productServiceId;
	}

	/**
	 * @param productServiceId the productServiceId to set
	 */
	public void setProductServiceId(String productServiceId) {
		this.productServiceId = productServiceId;
	}
}
