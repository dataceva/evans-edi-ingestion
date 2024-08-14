package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Transaction Segment Code: N1
 * Usage: Identify a party by type of organization, name and code.
 */
@EDISegment(tag="SPI")
public class SpecialInstruction {

	@EDIElement(fieldName="SPI01", dataElement="786")
	@NotNull
	@Size(min=2, max=2)
	private String securityLevelCode;

	/**
	 * @return the securityLevelCode
	 */
	public String getSecurityLevelCode() {
		return securityLevelCode;
	}

	/**
	 * @param securityLevelCode the securityLevelCode to set
	 */
	public void setSecurityLevelCode(String securityLevelCode) {
		this.securityLevelCode = securityLevelCode;
	}

	

}
