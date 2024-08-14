package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="L5")
public class LadingDescription {

	@EDIElement(fieldName="L501", dataElement="188")
	private String ladingLineItemNumber;
	
	@EDIElement(fieldName="L502", dataElement="81")
	private String ladingDescription;
	
	@EDIElement(fieldName="L503", dataElement="81")
	private String commodityCode;
	
	@EDIElement(fieldName="L504", dataElement="188")
	private String commodityCodeQualifier;
	
	@EDIElement(fieldName="L506", dataElement="81")
	private String markAndNumber;
	
	@EDIElement(fieldName="L507", dataElement="188")
	private String markAndNumberQualifier;
	
	@EDIElement(fieldName="L508", dataElement="188")
	private String commodityCodeQualifier2;
	
	@EDIElement(fieldName="L509", dataElement="81")
	private String commodityCode2;

	/**
	 * @return the ladingLineItemNumber
	 */
	public String getLadingLineItemNumber() {
		return ladingLineItemNumber;
	}

	/**
	 * @param ladingLineItemNumber the ladingLineItemNumber to set
	 */
	public void setLadingLineItemNumber(String ladingLineItemNumber) {
		this.ladingLineItemNumber = ladingLineItemNumber;
	}

	/**
	 * @return the ladingDescription
	 */
	public String getLadingDescription() {
		return ladingDescription;
	}

	/**
	 * @param ladingDescription the ladingDescription to set
	 */
	public void setLadingDescription(String ladingDescription) {
		this.ladingDescription = ladingDescription;
	}

	/**
	 * @return the commodityCode
	 */
	public String getCommodityCode() {
		return commodityCode;
	}

	/**
	 * @param commodityCode the commodityCode to set
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	/**
	 * @return the commodityCodeQualifier
	 */
	public String getCommodityCodeQualifier() {
		return commodityCodeQualifier;
	}

	/**
	 * @param commodityCodeQualifier the commodityCodeQualifier to set
	 */
	public void setCommodityCodeQualifier(String commodityCodeQualifier) {
		this.commodityCodeQualifier = commodityCodeQualifier;
	}

	/**
	 * @return the markAndNumber
	 */
	public String getMarkAndNumber() {
		return markAndNumber;
	}

	/**
	 * @param markAndNumber the markAndNumber to set
	 */
	public void setMarkAndNumber(String markAndNumber) {
		this.markAndNumber = markAndNumber;
	}

	/**
	 * @return the markAndNumberQualifier
	 */
	public String getMarkAndNumberQualifier() {
		return markAndNumberQualifier;
	}

	/**
	 * @param markAndNumberQualifier the markAndNumberQualifier to set
	 */
	public void setMarkAndNumberQualifier(String markAndNumberQualifier) {
		this.markAndNumberQualifier = markAndNumberQualifier;
	}

	/**
	 * @return the commodityCodeQualifier2
	 */
	public String getCommodityCodeQualifier2() {
		return commodityCodeQualifier2;
	}

	/**
	 * @param commodityCodeQualifier2 the commodityCodeQualifier2 to set
	 */
	public void setCommodityCodeQualifier2(String commodityCodeQualifier2) {
		this.commodityCodeQualifier2 = commodityCodeQualifier2;
	}

	/**
	 * @return the commodityCode2
	 */
	public String getCommodityCode2() {
		return commodityCode2;
	}

	/**
	 * @param commodityCode2 the commodityCode2 to set
	 */
	public void setCommodityCode2(String commodityCode2) {
		this.commodityCode2 = commodityCode2;
	}

}
