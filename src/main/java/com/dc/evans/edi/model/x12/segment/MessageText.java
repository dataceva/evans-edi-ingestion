package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;


@EDISegment(tag="MSG")
public class MessageText {

	@EDIElement(fieldName="MSG01", dataElement="933")
	@Size(min=1, max=4096)
	private String freeFormMessage;

	public String getFreeFormMessage() {
		return freeFormMessage;
	}


	public void setFreeFormMessage(String freeFormMessage) {
		this.freeFormMessage = freeFormMessage;
	}
	

}
