package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="RED")
public class RelatedData {
	
	@EDIElement(fieldName="RED01", dataElement="352")
	@Size(min=1, max=80)
	private String description;

	@EDIElement(fieldName="RED02", dataElement="1609")
	@Size(min=2, max=3)
	private String relatedDataIdentificationCode;

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
	 * @return the relatedDataIdentificationCode
	 */
	public String getRelatedDataIdentificationCode() {
		return relatedDataIdentificationCode;
	}

	/**
	 * @param relatedDataIdentificationCode the relatedDataIdentificationCode to set
	 */
	public void setRelatedDataIdentificationCode(String relatedDataIdentificationCode) {
		this.relatedDataIdentificationCode = relatedDataIdentificationCode;
	}
}
