package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="MAN")
public class MarksAndNumbers {

	@Size(min=1, max=2)
	@EDIElement(fieldName="MAN01", dataElement="88")
	private String marksAndNumbersQualifier;
	
	@Size(min=1, max=48)
	@EDIElement(fieldName="MAN02", dataElement="87")
	private String marksAndNumbers;

	@Size(min=1, max=48)
	@EDIElement(fieldName="MAN03", dataElement="87")
	private String marksAndNumbers2;

	@Size(min=1, max=2)
	@EDIElement(fieldName="MAN04", dataElement="88")
	private String marksAndNumbersQualifier2;
	
	@Size(min=1, max=48)
	@EDIElement(fieldName="MAN05", dataElement="87")
	private String marksAndNumber3;

	@Size(min=1, max=48)
	@EDIElement(fieldName="MAN06", dataElement="87")
	private String marksAndNumbers4;

	/**
	 * @return the marksAndNumbersQualifier
	 */
	public String getMarksAndNumbersQualifier() {
		return marksAndNumbersQualifier;
	}

	/**
	 * @param marksAndNumbersQualifier the marksAndNumbersQualifier to set
	 */
	public void setMarksAndNumbersQualifier(String marksAndNumbersQualifier) {
		this.marksAndNumbersQualifier = marksAndNumbersQualifier;
	}

	/**
	 * @return the marksAndNumbers
	 */
	public String getMarksAndNumbers() {
		return marksAndNumbers;
	}

	/**
	 * @param marksAndNumbers the marksAndNumbers to set
	 */
	public void setMarksAndNumbers(String marksAndNumbers) {
		this.marksAndNumbers = marksAndNumbers;
	}

	/**
	 * @return the marksAndNumbers2
	 */
	public String getMarksAndNumbers2() {
		return marksAndNumbers2;
	}

	/**
	 * @param marksAndNumbers2 the marksAndNumbers2 to set
	 */
	public void setMarksAndNumbers2(String marksAndNumbers2) {
		this.marksAndNumbers2 = marksAndNumbers2;
	}

	/**
	 * @return the marksAndNumbersQualifier2
	 */
	public String getMarksAndNumbersQualifier2() {
		return marksAndNumbersQualifier2;
	}

	/**
	 * @param marksAndNumbersQualifier2 the marksAndNumbersQualifier2 to set
	 */
	public void setMarksAndNumbersQualifier2(String marksAndNumbersQualifier2) {
		this.marksAndNumbersQualifier2 = marksAndNumbersQualifier2;
	}

	/**
	 * @return the marksAndNumber3
	 */
	public String getMarksAndNumber3() {
		return marksAndNumber3;
	}

	/**
	 * @param marksAndNumber3 the marksAndNumber3 to set
	 */
	public void setMarksAndNumber3(String marksAndNumber3) {
		this.marksAndNumber3 = marksAndNumber3;
	}

	/**
	 * @return the marksAndNumbers4
	 */
	public String getMarksAndNumbers4() {
		return marksAndNumbers4;
	}

	/**
	 * @param marksAndNumbers4 the marksAndNumbers4 to set
	 */
	public void setMarksAndNumbers4(String marksAndNumbers4) {
		this.marksAndNumbers4 = marksAndNumbers4;
	}
}
