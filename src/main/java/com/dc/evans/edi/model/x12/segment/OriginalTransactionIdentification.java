package com.dc.evans.edi.model.x12.segment;

import java.util.Date;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="OTI")
public class OriginalTransactionIdentification {
	
	@EDIElement(fieldName="OTI01", dataElement="110")
	@Size(min=1, max=2)
	private String applicationAcknowledgmentCode;

	@EDIElement(fieldName="OTI02", dataElement="128")
	@Size(min=2, max=3)
	private String refernceIdentificationQualifier;

	@EDIElement(fieldName="OTI03", dataElement="127")
	@Size(min=1, max=50)
	private String refernceIdentification;

	@EDIElement(fieldName="OTI04", dataElement="142")
	@Size(min=2, max=15)
	private String applicationSenderCode;

	@EDIElement(fieldName="OTI05", dataElement="124")
	@Size(min=2, max=15)
	private String applicationReceiverCode;
	
	@EDIElement(fieldName="OTI06", dataElement="373")
	@NotNull
	@Size(min=8, max=8)
	@EDIElementFormat("yyyyMMdd")
	private Date date;

	@EDIElement(fieldName="OTI07", dataElement="337")
	@NotNull
	@Size(min=4, max=8)
	private String time;

	@EDIElement(fieldName="OTI08", dataElement="28")
	@NotNull
	@Size(min=1, max=9)
	private String groupControlNumber;

	@EDIElement(fieldName="OTI09", dataElement="329")
	@NotNull
	@Size(min=4, max=9)
	private String transactionControlNumber;

	@EDIElement(fieldName="OTI10", dataElement="143")
	@NotNull
	@Size(min=3, max=3)
	private String transactionidentifierCode;

	/**
	 * @return the applicationAcknowledgmentCode
	 */
	public String getApplicationAcknowledgmentCode() {
		return applicationAcknowledgmentCode;
	}

	/**
	 * @param applicationAcknowledgmentCode the applicationAcknowledgmentCode to set
	 */
	public void setApplicationAcknowledgmentCode(String applicationAcknowledgmentCode) {
		this.applicationAcknowledgmentCode = applicationAcknowledgmentCode;
	}

	/**
	 * @return the refernceIdentificationQualifier
	 */
	public String getRefernceIdentificationQualifier() {
		return refernceIdentificationQualifier;
	}

	/**
	 * @param refernceIdentificationQualifier the refernceIdentificationQualifier to set
	 */
	public void setRefernceIdentificationQualifier(String refernceIdentificationQualifier) {
		this.refernceIdentificationQualifier = refernceIdentificationQualifier;
	}

	/**
	 * @return the refernceIdentification
	 */
	public String getRefernceIdentification() {
		return refernceIdentification;
	}

	/**
	 * @param refernceIdentification the refernceIdentification to set
	 */
	public void setRefernceIdentification(String refernceIdentification) {
		this.refernceIdentification = refernceIdentification;
	}

	/**
	 * @return the applicationSenderCode
	 */
	public String getApplicationSenderCode() {
		return applicationSenderCode;
	}

	/**
	 * @param applicationSenderCode the applicationSenderCode to set
	 */
	public void setApplicationSenderCode(String applicationSenderCode) {
		this.applicationSenderCode = applicationSenderCode;
	}

	/**
	 * @return the applicationReceiverCode
	 */
	public String getApplicationReceiverCode() {
		return applicationReceiverCode;
	}

	/**
	 * @param applicationReceiverCode the applicationReceiverCode to set
	 */
	public void setApplicationReceiverCode(String applicationReceiverCode) {
		this.applicationReceiverCode = applicationReceiverCode;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the groupControlNumber
	 */
	public String getGroupControlNumber() {
		return groupControlNumber;
	}

	/**
	 * @param groupControlNumber the groupControlNumber to set
	 */
	public void setGroupControlNumber(String groupControlNumber) {
		this.groupControlNumber = groupControlNumber;
	}

	/**
	 * @return the transactionControlNumber
	 */
	public String getTransactionControlNumber() {
		return transactionControlNumber;
	}

	/**
	 * @param transactionControlNumber the transactionControlNumber to set
	 */
	public void setTransactionControlNumber(String transactionControlNumber) {
		this.transactionControlNumber = transactionControlNumber;
	}

	/**
	 * @return the transactionidentifierCode
	 */
	public String getTransactionidentifierCode() {
		return transactionidentifierCode;
	}

	/**
	 * @param transactionidentifierCode the transactionidentifierCode to set
	 */
	public void setTransactionidentifierCode(String transactionidentifierCode) {
		this.transactionidentifierCode = transactionidentifierCode;
	}
}
