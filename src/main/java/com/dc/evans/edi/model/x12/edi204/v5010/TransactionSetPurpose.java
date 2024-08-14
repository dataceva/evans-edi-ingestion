package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="B2A")
public class TransactionSetPurpose {
	
	@EDIElement(fieldName="B2A01")
	@NotNull
	@Size(min=2, max=4)
	private String transactionSetPurposeCode;
	
	@EDIElement(fieldName="B2A02")
	private String applicationType;

	/**
	 * @return the transactionSetPurposeCode
	 */
	public String getTransactionSetPurposeCode() {
		return transactionSetPurposeCode;
	}

	/**
	 * @param transactionSetPurposeCode the transactionSetPurposeCode to set
	 */
	public void setTransactionSetPurposeCode(String transactionSetPurposeCode) {
		this.transactionSetPurposeCode = transactionSetPurposeCode;
	}

	/**
	 * @return the applicationType
	 */
	public String getApplicationType() {
		return applicationType;
	}

	/**
	 * @param applicationType the applicationType to set
	 */
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

}
