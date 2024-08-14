package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.enums.NameEnums;

/**
 * Transaction Segment Code: N1
 * Usage: Identify a party by type of organization, name and code.
 */
@EDISegment(tag="N1")
public class Name {

	@EDIElement(fieldName="N101", dataElement="98")
	@NotNull
	@Size(min=2, max=3)
	private String entityIdentifierCode;

	@EDIElement(fieldName="N102", dataElement="93")
	@Size(min=1, max=35)
	private String name;

	@EDIElement(fieldName="N103", dataElement="66")
	@Size(min=1, max=2)
	private String identificationCodeQualifier;

	@EDIElement(fieldName="N104", dataElement="67")
	@Size(min=2, max=17)
	private String identificationCode;
	
	/**
	 * @return the entityIdentifierCode
	 */
	public String getEntityIdentifierCode() {
		return entityIdentifierCode;
	}


	/**
	 * @param entityIdentifierCode the entityIdentifierCode to set
	 */
	public void setEntityIdentifierCode(String entityIdentifierCode) {
		this.entityIdentifierCode = entityIdentifierCode;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the identificationCodeQualifier
	 */
	public String getIdentificationCodeQualifier() {
		return identificationCodeQualifier;
	}


	/**
	 * @param identificationCodeQualifier the identificationCodeQualifier to set
	 */
	public void setIdentificationCodeQualifier(String identificationCodeQualifier) {
		this.identificationCodeQualifier = identificationCodeQualifier;
	}


	/**
	 * @return the identificationCode
	 */
	public String getIdentificationCode() {
		return identificationCode;
	}


	/**
	 * @param identificationCode the identificationCode to set
	 */
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}


	public String getType() {
		return NameEnums.getByCode(getEntityIdentifierCode()).toString();
	}

}
