package com.dc.evans.edi.model.x12.edi204.v4010;

import java.util.ArrayList;
import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.LadingDetail;
import com.dc.evans.edi.model.x12.segment.OrderIdentificationDetail;

@EDISegmentGroup
public class OrderDetailGroup {
	
	@NotNull
	private OrderIdentificationDetail orderIdentificationDetail;
	
	@NotNull
	@Size(max=100000)
	@EDICollectionType(LadingDetail.class)
	private Collection<LadingDetail> ladingDetail = new ArrayList<LadingDetail>();
	
	@Size(min=1)
	@NotNull
	@EDICollectionType(LadingDetailGroup.class)
	private Collection<LadingDetailGroup> ladingDetailGroup = new ArrayList<LadingDetailGroup>();

	/**
	 * @return the orderIdentificationDetail
	 */
	public OrderIdentificationDetail getOrderIdentificationDetail() {
		return orderIdentificationDetail;
	}

	/**
	 * @param orderIdentificationDetail the orderIdentificationDetail to set
	 */
	public void setOrderIdentificationDetail(OrderIdentificationDetail orderIdentificationDetail) {
		this.orderIdentificationDetail = orderIdentificationDetail;
	}

	/**
	 * @return the ladingDetail
	 */
	public Collection<LadingDetail> getLadingDetail() {
		return ladingDetail;
	}

	/**
	 * @param ladingDetail the ladingDetail to set
	 */
	public void setLadingDetail(Collection<LadingDetail> ladingDetail) {
		this.ladingDetail = ladingDetail;
	}

	/**
	 * @return the ladingDetailGroup
	 */
	public Collection<LadingDetailGroup> getLadingDetailGroup() {
		return ladingDetailGroup;
	}

	/**
	 * @param ladingDetailGroup the ladingDetailGroup to set
	 */
	public void setLadingDetailGroup(Collection<LadingDetailGroup> ladingDetailGroup) {
		this.ladingDetailGroup = ladingDetailGroup;
	}
	
}
