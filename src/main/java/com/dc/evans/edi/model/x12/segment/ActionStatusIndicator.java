package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="ASI")
public class ActionStatusIndicator {

	@EDIElement(fieldName="ASI01", dataElement="306")
	private String actionCode;
	
	@EDIElement(fieldName="ASI02", dataElement="875")
	private String maintainenceTypeCode;
	
	@EDIElement(fieldName="ASI03", dataElement="641")
	private String statusReasonCode;

	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}

	/**
	 * @param actionCode the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	/**
	 * @return the maintainenceTypeCode
	 */
	public String getMaintainenceTypeCode() {
		return maintainenceTypeCode;
	}

	/**
	 * @param maintainenceTypeCode the maintainenceTypeCode to set
	 */
	public void setMaintainenceTypeCode(String maintainenceTypeCode) {
		this.maintainenceTypeCode = maintainenceTypeCode;
	}

	/**
	 * @return the statusReasonCode
	 */
	public String getStatusReasonCode() {
		return statusReasonCode;
	}

	/**
	 * @param statusReasonCode the statusReasonCode to set
	 */
	public void setStatusReasonCode(String statusReasonCode) {
		this.statusReasonCode = statusReasonCode;
	}
	
	
}
