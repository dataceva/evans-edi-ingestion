package com.dc.evans.edi.model.x12.edi204.v4010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="AT5")
public class BOLHandlingRequirement {
	
	@EDIElement(fieldName="AT501",dataElement = "152")
	private String specialHandlingCode;

	/**
	 * @return the specialHandlingCode
	 */
	public String getSpecialHandlingCode() {
		return specialHandlingCode;
	}

	/**
	 * @param specialHandlingCode the specialHandlingCode to set
	 */
	public void setSpecialHandlingCode(String specialHandlingCode) {
		this.specialHandlingCode = specialHandlingCode;
	}
	

}
