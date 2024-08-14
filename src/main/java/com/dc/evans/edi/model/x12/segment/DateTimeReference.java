package com.dc.evans.edi.model.x12.segment;

import java.util.Date;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.enums.DateTimeReferenceEnums;

@EDISegment(tag="DTM")
public class DateTimeReference {

	@EDIElement(fieldName="DTM01", dataElement="374")
	@NotNull
	@Size(min=0, max=3)
	private String dateTimeQualifier;
	
	@EDIElement(fieldName="DTM02", dataElement="373")
	@EDIElementFormat("yyyyMMdd")
	private Date date;

	@EDIElement(fieldName="DTM03", dataElement="337")
	@NotNull
	@Size(min=4, max=8)
	@EDIElementFormat("HHmm")
	private Date time;

	@EDIElement(fieldName="DTM04", dataElement="623")
	@NotNull
	@Size(min=2, max=2)
	private String timeCode;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateTimeQualifier() {
		return dateTimeQualifier;
	}
	
	public void setDateTimeQualifier(String dateTimeQualifier) {
		this.dateTimeQualifier = dateTimeQualifier;
	}

	public String getType() {
		return DateTimeReferenceEnums.getByCode(getDateTimeQualifier()).toString();
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the timeCode
	 */
	public String getTimeCode() {
		return timeCode;
	}

	/**
	 * @param timeCode the timeCode to set
	 */
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}

	@Override
	public String toString() {
		return "DateTimeReference [dateTimeQualifier=" + dateTimeQualifier
				+ ", date=" + date + "]";
	}
}
