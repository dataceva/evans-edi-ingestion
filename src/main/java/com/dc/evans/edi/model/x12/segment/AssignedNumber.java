package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="LX")
public class AssignedNumber {
	@EDIElement(fieldName="LX01", dataElement="554")
	private Integer assignedIdentificationNumber;

	/**
	 * @return the assignedIdentificationNumber
	 */
	public int getAssignedIdentificationNumber() {
		return assignedIdentificationNumber;
	}

	/**
	 * @param assignedIdentificationNumber the assignedIdentificationNumber to set
	 */
	public void setAssignedIdentificationNumber(int assignedIdentificationNumber) {
		this.assignedIdentificationNumber = assignedIdentificationNumber;
	}
}
