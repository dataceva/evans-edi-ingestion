package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;


@EDISegment(tag="MIT")
public class MessageIdentification {

	@EDIElement(fieldName="MIT01", dataElement="127")
	@Size(min=1, max=30)
	private String referenceIdentification;

	@EDIElement(fieldName="MIT02", dataElement="352")
	@Size(min=1, max=80)
	private String description;

	@EDIElement(fieldName="MIT03", dataElement="931")
	@Size(min=1, max=3)
	private String pageWidth;

	@EDIElement(fieldName="MIT04", dataElement="932")
	@Size(min=1, max=3)
	private String pageLength;

	/**
	 * @return the referenceIdentification
	 */
	public String getReferenceIdentification() {
		return referenceIdentification;
	}

	/**
	 * @param referenceIdentification the referenceIdentification to set
	 */
	public void setReferenceIdentification(String referenceIdentification) {
		this.referenceIdentification = referenceIdentification;
	}

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
	 * @return the pageWidth
	 */
	public String getPageWidth() {
		return pageWidth;
	}

	/**
	 * @param pageWidth the pageWidth to set
	 */
	public void setPageWidth(String pageWidth) {
		this.pageWidth = pageWidth;
	}

	/**
	 * @return the pageLength
	 */
	public String getPageLength() {
		return pageLength;
	}

	/**
	 * @param pageLength the pageLength to set
	 */
	public void setPageLength(String pageLength) {
		this.pageLength = pageLength;
	}

}
