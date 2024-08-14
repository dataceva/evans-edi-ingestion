package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;

@EDISegment(tag="S5")
public class StopOffDetail {

	@EDIElement(fieldName="S501",dataElement="165")
	@NotNull
	private String stopSequenceNumber;

	@EDIElement(fieldName="S502",dataElement="163")
	@NotNull
	private String stopReasonCode;

	@EDIElement(fieldName="S503",dataElement="81")
	@NotNull
	private String weight;

	@EDIElement(fieldName="S504",dataElement="188")
	@NotNull
	private String weightUOM;

	@EDIElement(fieldName="S505",dataElement="382")
	@NotNull
	private Integer numberOfUnitShipped;

	@EDIElement(fieldName="S505",dataElement="382")
	@NotNull
	private String unitUOM;

	/**
	 * @return the stopSequenceNumber
	 */
	public String getStopSequenceNumber() {
		return stopSequenceNumber;
	}

	/**
	 * @param stopSequenceNumber the stopSequenceNumber to set
	 */
	public void setStopSequenceNumber(String stopSequenceNumber) {
		this.stopSequenceNumber = stopSequenceNumber;
	}

	/**
	 * @return the stopReasonCode
	 */
	public String getStopReasonCode() {
		return stopReasonCode;
	}

	/**
	 * @param stopReasonCode the stopReasonCode to set
	 */
	public void setStopReasonCode(String stopReasonCode) {
		this.stopReasonCode = stopReasonCode;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
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
	 * @return the numberOfUnitShipped
	 */
	public Integer getNumberOfUnitShipped() {
		return numberOfUnitShipped;
	}

	/**
	 * @param numberOfUnitShipped the numberOfUnitShipped to set
	 */
	public void setNumberOfUnitShipped(Integer numberOfUnitShipped) {
		this.numberOfUnitShipped = numberOfUnitShipped;
	}

	/**
	 * @return the unitUOM
	 */
	public String getUnitUOM() {
		return unitUOM;
	}

	/**
	 * @param unitUOM the unitUOM to set
	 */
	public void setUnitUOM(String unitUOM) {
		this.unitUOM = unitUOM;
	}
	
}
