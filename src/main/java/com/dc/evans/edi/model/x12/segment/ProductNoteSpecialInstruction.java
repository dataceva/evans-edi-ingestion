package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;


@EDISegment(tag="MTX")
public class ProductNoteSpecialInstruction {

	@EDIElement(fieldName="MTX01", dataElement="363")
	@Size(min=3, max=3)
	private String noteReferenceCode;
	
	
	@EDIElement(fieldName="MTX02", dataElement="3")
	@Size(min=1, max=4096)
	private String freeFormMessage;


	public String getNoteReferenceCode() {
		return noteReferenceCode;
	}


	public void setNoteReferenceCode(String noteReferenceCode) {
		this.noteReferenceCode = noteReferenceCode;
	}


	public String getFreeFormMessage() {
		return freeFormMessage;
	}


	public void setFreeFormMessage(String freeFormMessage) {
		this.freeFormMessage = freeFormMessage;
	}
	

}
