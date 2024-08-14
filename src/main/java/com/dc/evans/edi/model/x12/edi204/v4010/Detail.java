package com.dc.evans.edi.model.x12.edi204.v4010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.edi.IEDIMessageBodyDetail;

@EDISegmentGroup
public class Detail implements IEDIMessageBodyDetail<Detail> {

	@Size(min=1)
	@NotNull
	@EDICollectionType(StopOffDetailGroup.class)
	private Collection<StopOffDetailGroup> stopOffDetailGroup;

	/**
	 * @return the stopOffDetailGroup
	 */
	public Collection<StopOffDetailGroup> getStopOffDetailGroup() {
		return stopOffDetailGroup;
	}

	/**
	 * @param stopOffDetailGroup the stopOffDetailGroup to set
	 */
	public void setStopOffDetailGroup(Collection<StopOffDetailGroup> stopOffDetailGroup) {
		this.stopOffDetailGroup = stopOffDetailGroup;
	}
	
}
