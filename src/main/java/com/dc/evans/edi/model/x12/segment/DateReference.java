package com.dc.evans.edi.model.x12.segment;

import java.util.Date;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="G62")
public class DateReference {

	@EDIElement(fieldName="G6201", dataElement="374")
	@NotNull
	@Size(min=0, max=3)
	private String dateQualifier;
	
	@EDIElement(fieldName="G6202", dataElement="373")
	@EDIElementFormat("yyyyMMdd")
	private Date date;

	@EDIElement(fieldName="G6203", dataElement="374")
	@NotNull
	@Size(min=0, max=3)
	private String timeQualifier;
	
	@EDIElement(fieldName="G6204", dataElement="373")
	@EDIElementFormat("hhmm")
	private String time;

	/**
	 * @return the dateQualifier
	 */
	public String getDateQualifier() {
		return dateQualifier;
	}

	/**
	 * @param dateQualifier the dateQualifier to set
	 */
	public void setDateQualifier(String dateQualifier) {
		this.dateQualifier = dateQualifier;
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
	 * @return the timeQualifier
	 */
	public String getTimeQualifier() {
		return timeQualifier;
	}

	/**
	 * @param timeQualifier the timeQualifier to set
	 */
	public void setTimeQualifier(String timeQualifier) {
		this.timeQualifier = timeQualifier;
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
	
}
