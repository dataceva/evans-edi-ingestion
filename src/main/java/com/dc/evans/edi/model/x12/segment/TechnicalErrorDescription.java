package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="TED")
public class TechnicalErrorDescription {
	
	@EDIElement(fieldName="TED01", dataElement="647")
	@Size(min=1, max=3)
	private String applicationErrorConditionCode;

	@EDIElement(fieldName="TED02", dataElement="3")
	@Size(min=2, max=3)
	private String message;

	@EDIElement(fieldName="TED03", dataElement="724")
	@Size(min=1, max=50)
	private String badElementData;

	/**
	 * @return the applicationErrorConditionCode
	 */
	public String getApplicationErrorConditionCode() {
		return applicationErrorConditionCode;
	}

	/**
	 * @param applicationErrorConditionCode the applicationErrorConditionCode to set
	 */
	public void setApplicationErrorConditionCode(String applicationErrorConditionCode) {
		this.applicationErrorConditionCode = applicationErrorConditionCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the badElementData
	 */
	public String getBadElementData() {
		return badElementData;
	}

	/**
	 * @param badElementData the badElementData to set
	 */
	public void setBadElementData(String badElementData) {
		this.badElementData = badElementData;
	}

}
