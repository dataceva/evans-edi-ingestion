package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="L4")
public class Dimension {

	@EDIElement(fieldName="L401", dataElement="737")
	@Size(min=2, max=2)
	private String lenght;

	@EDIElement(fieldName="L402", dataElement="738")
	@Size(min=1, max=3)
	private String width;

	@EDIElement(fieldName="L403", dataElement="739")
	@Size(min=1, max=20)
	private String height;

	@EDIElement(fieldName="L404", dataElement="C001")
	@Size(min=0, max=20)
	private String unit;

	@EDIElement(fieldName="L405", dataElement="739")
	@Size(min=1, max=20)
	private String quantity;

	@EDIElement(fieldName="L406", dataElement="C001")
	@Size(min=0, max=20)
	private String industryCode;

	/**
	 * @return the lenght
	 */
	public String getLenght() {
		return lenght;
	}

	/**
	 * @param lenght the lenght to set
	 */
	public void setLenght(String lenght) {
		this.lenght = lenght;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the industryCode
	 */
	public String getIndustryCode() {
		return industryCode;
	}

	/**
	 * @param industryCode the industryCode to set
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	
}
