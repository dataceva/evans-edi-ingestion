package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="CSH")
public class SalesRequirement {

	@EDIElement(fieldName="CSH01", dataElement="563")
	@Size(min=1,max=2)
	private String salesRequirementCode;

	/**
	 * @return the salesRequirementCode
	 */
	public String getSalesRequirementCode() {
		return salesRequirementCode;
	}

	/**
	 * @param salesRequirementCode the salesRequirementCode to set
	 */
	public void setSalesRequirementCode(String salesRequirementCode) {
		this.salesRequirementCode = salesRequirementCode;
	}
	
}
