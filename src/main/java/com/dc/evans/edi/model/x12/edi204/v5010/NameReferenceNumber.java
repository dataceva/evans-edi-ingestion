package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.Name;
import com.dc.evans.edi.model.x12.segment.ReferenceNumber;

@EDISegmentGroup
public class NameReferenceNumber {
	
	private Name name;
	
	@EDICollectionType(ReferenceNumber.class)
	@Size(min=0, max=12)
	private Collection<ReferenceNumber> referenceNumbers;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Collection<ReferenceNumber> getReferenceNumbers() {
		return referenceNumbers;
	}

	public void setReferenceNumbers(Collection<ReferenceNumber> referenceNumbers) {
		this.referenceNumbers = referenceNumbers;
	}

	@Override
	public String toString() {
		return "NameReferenceNumber [name=" + name + ", referenceNumbers="
				+ referenceNumbers + "]";
	}
}
