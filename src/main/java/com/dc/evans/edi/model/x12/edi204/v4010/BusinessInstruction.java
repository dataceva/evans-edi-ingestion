package com.dc.evans.edi.model.x12.edi204.v4010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="L11")
public class BusinessInstruction {
	
	@EDIElement(fieldName="L1101",dataElement="128")
	@NotNull
	@Size(min = 2, max = 2)
	private String referenceIdentificationQualifier;
	
	@EDIElement(fieldName="L1102",dataElement="127",conditional=true)
	@Size(min = 1, max = 35)
	private String referenceIdentification;
	
	@EDIElement(fieldName="L1103",dataElement="352",conditional=true)
	@Size(min = 1, max = 2)
	private String referenceDescription;


	/**
	 * @return the referenceIdentificationQualifier
	 */
	public String getReferenceIdentificationQualifier() {
		return referenceIdentificationQualifier;
	}


	/**
	 * @param referenceIdentificationQualifier the referenceIdentificationQualifier to set
	 */
	public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
		this.referenceIdentificationQualifier = referenceIdentificationQualifier;
	}


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
	 * @return the referenceDescription
	 */
	public String getReferenceDescription() {
		return referenceDescription;
	}

	/**
	 * @param referenceDescription the referenceDescription to set
	 */
	public void setReferenceDescription(String referenceDescription) {
		this.referenceDescription = referenceDescription;
	} 
	
}
