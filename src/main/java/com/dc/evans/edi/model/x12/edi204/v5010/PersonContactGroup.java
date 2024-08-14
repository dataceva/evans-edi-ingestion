package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.PersonContact;

@EDISegmentGroup
public class PersonContactGroup {

	private PersonContact contact;

	@NotNull
	@Size(max=100000)
	@EDICollectionType(BusinessInstruction.class)
	private Collection<BusinessInstruction> businessInstructions;

	/**
	 * @return the contact
	 */
	public PersonContact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(PersonContact contact) {
		this.contact = contact;
	}

	/**
	 * @return the businessInstructions
	 */
	public Collection<BusinessInstruction> getBusinessInstructions() {
		return businessInstructions;
	}

	/**
	 * @param businessInstructions the businessInstructions to set
	 */
	public void setBusinessInstructions(Collection<BusinessInstruction> businessInstructions) {
		this.businessInstructions = businessInstructions;
	}
	
}
