package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.ShipmentWeightAndQuantityDetails;

@EDISegmentGroup
public class ShipmentWeightAndQuantityDetailGroup {
	@NotNull
	private ShipmentWeightAndQuantityDetails shipmentWeightAndQuantityDetails;

	@NotNull
	@Size(max=100000)
	@EDICollectionType(PersonContactGroup.class)
	private Collection<PersonContactGroup> personContactGroup;

	/**
	 * @return the shipmentWeightAndQuantityDetails
	 */
	public ShipmentWeightAndQuantityDetails getShipmentWeightAndQuantityDetails() {
		return shipmentWeightAndQuantityDetails;
	}

	/**
	 * @param shipmentWeightAndQuantityDetails the shipmentWeightAndQuantityDetails to set
	 */
	public void setShipmentWeightAndQuantityDetails(ShipmentWeightAndQuantityDetails shipmentWeightAndQuantityDetails) {
		this.shipmentWeightAndQuantityDetails = shipmentWeightAndQuantityDetails;
	}

	/**
	 * @return the personContactGroup
	 */
	public Collection<PersonContactGroup> getPersonContactGroup() {
		return personContactGroup;
	}

	/**
	 * @param personContactGroup the personContactGroup to set
	 */
	public void setPersonContactGroup(Collection<PersonContactGroup> personContactGroup) {
		this.personContactGroup = personContactGroup;
	}

	
}
