package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;

@EDISegment(tag="AK4")
public class ElementNoteInformation {
	
	@EDIElement(fieldName="AK401", dataElement="721")
	@NotNull
	private Integer segmentposition;
	
	@EDIElement(fieldName="AK402", dataElement="725")
	@NotNull
	private Integer elementReferenceNumber;
	
	@EDIElement(fieldName="AK403", dataElement="725")
	@NotNull
	private String elementSyntaxErrorCode;
	
	@EDIElement(fieldName="AK404", dataElement="725")
	@NotNull
	private String elementData;

	/**
	 * @return the segmentposition
	 */
	public Integer getSegmentposition() {
		return segmentposition;
	}

	/**
	 * @param segmentposition the segmentposition to set
	 */
	public void setSegmentposition(Integer segmentposition) {
		this.segmentposition = segmentposition;
	}

	/**
	 * @return the elementReferenceNumber
	 */
	public Integer getElementReferenceNumber() {
		return elementReferenceNumber;
	}

	/**
	 * @param elementReferenceNumber the elementReferenceNumber to set
	 */
	public void setElementReferenceNumber(Integer elementReferenceNumber) {
		this.elementReferenceNumber = elementReferenceNumber;
	}

	/**
	 * @return the elementSyntaxErrorCode
	 */
	public String getElementSyntaxErrorCode() {
		return elementSyntaxErrorCode;
	}

	/**
	 * @param elementSyntaxErrorCode the elementSyntaxErrorCode to set
	 */
	public void setElementSyntaxErrorCode(String elementSyntaxErrorCode) {
		this.elementSyntaxErrorCode = elementSyntaxErrorCode;
	}

	/**
	 * @return the elementData
	 */
	public String getElementData() {
		return elementData;
	}

	/**
	 * @param elementData the elementData to set
	 */
	public void setElementData(String elementData) {
		this.elementData = elementData;
	}
}
