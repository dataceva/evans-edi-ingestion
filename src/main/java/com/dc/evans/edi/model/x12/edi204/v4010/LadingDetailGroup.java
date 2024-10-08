package com.dc.evans.edi.model.x12.edi204.v4010;

import java.util.ArrayList;
import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.LadingDescription;
import com.dc.evans.edi.model.x12.segment.PersonContact;
import com.dc.evans.edi.model.x12.segment.ShipmentWeightAndQuantityDetails;

@EDISegmentGroup
public class LadingDetailGroup {
	
	@NotNull
	private LadingDescription ladingDescription;

	@Size(min=1)
	@NotNull
	@EDICollectionType(ShipmentWeightAndQuantityDetailGroup.class)
	private Collection<ShipmentWeightAndQuantityDetailGroup> shipmentWeightAndQuantityDetailGroup = new ArrayList<>();
	
	/**
	 * @return the ladingDescription
	 */
	public LadingDescription getLadingDescription() {
		return ladingDescription;
	}

	/**
	 * @param ladingDescription the ladingDescription to set
	 */
	public void setLadingDescription(LadingDescription ladingDescription) {
		this.ladingDescription = ladingDescription;
	}

	/**
	 * @return the shipmentWeightAndQuantityDetailGroup
	 */
	public Collection<ShipmentWeightAndQuantityDetailGroup> getShipmentWeightAndQuantityDetailGroup() {
		return shipmentWeightAndQuantityDetailGroup;
	}

	/**
	 * @param shipmentWeightAndQuantityDetailGroup the shipmentWeightAndQuantityDetailGroup to set
	 */
	public void setShipmentWeightAndQuantityDetailGroup(
			Collection<ShipmentWeightAndQuantityDetailGroup> shipmentWeightAndQuantityDetailGroup) {
		this.shipmentWeightAndQuantityDetailGroup = shipmentWeightAndQuantityDetailGroup;
	}
}
