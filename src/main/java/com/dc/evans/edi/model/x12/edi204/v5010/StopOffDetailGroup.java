package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.DateReference;
import com.dc.evans.edi.model.x12.segment.NoteSpecialInstructions;
import com.dc.evans.edi.model.x12.segment.PersonContact;
import com.dc.evans.edi.model.x12.segment.ShipmentWeightAndQuantityDetails;

@EDISegmentGroup
public class StopOffDetailGroup {
	
	private StopOffDetail stopOffDetail;
	
	@EDICollectionType(BusinessInstruction.class)
	@Size(min=0, max=12)
	private Collection<BusinessInstruction> businessInstruction;

	@EDICollectionType(DateReference.class)
	@Size(min=0, max=12)
	private Collection<DateReference> dateReference;
	
	private ShipmentWeightAndQuantityDetails shipmentWeightAndQuantityDetails;
	
	private PalletInformation palletInformation;
	
	@NotNull
	@Size(max=100000)
	@EDICollectionType(NoteSpecialInstructions.class)
	private Collection<NoteSpecialInstructions> noteSpecialInstructions;

	@Size(min=1)
	@NotNull
	@EDICollectionType(StopOffDetailContactGroup.class)
	private Collection<StopOffDetailContactGroup> stopOffDetailContactGroup;

	@Size(min=1)
	@NotNull
	@EDICollectionType(OrderDetailGroup.class)
	private Collection<OrderDetailGroup> orderDetailGroup;

	/**
	 * @return the stopOffDetail
	 */
	public StopOffDetail getStopOffDetail() {
		return stopOffDetail;
	}

	/**
	 * @param stopOffDetail the stopOffDetail to set
	 */
	public void setStopOffDetail(StopOffDetail stopOffDetail) {
		this.stopOffDetail = stopOffDetail;
	}

	/**
	 * @return the businessInstruction
	 */
	public Collection<BusinessInstruction> getBusinessInstruction() {
		return businessInstruction;
	}

	/**
	 * @param businessInstruction the businessInstruction to set
	 */
	public void setBusinessInstruction(Collection<BusinessInstruction> businessInstruction) {
		this.businessInstruction = businessInstruction;
	}

	/**
	 * @return the dateReference
	 */
	public Collection<DateReference> getDateReference() {
		return dateReference;
	}

	/**
	 * @param dateReference the dateReference to set
	 */
	public void setDateReference(Collection<DateReference> dateReference) {
		this.dateReference = dateReference;
	}

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
	 * @return the palletInformation
	 */
	public PalletInformation getPalletInformation() {
		return palletInformation;
	}

	/**
	 * @param palletInformation the palletInformation to set
	 */
	public void setPalletInformation(PalletInformation palletInformation) {
		this.palletInformation = palletInformation;
	}

	/**
	 * @return the noteSpecialInstructions
	 */
	public Collection<NoteSpecialInstructions> getNoteSpecialInstructions() {
		return noteSpecialInstructions;
	}

	/**
	 * @param noteSpecialInstructions the noteSpecialInstructions to set
	 */
	public void setNoteSpecialInstructions(Collection<NoteSpecialInstructions> noteSpecialInstructions) {
		this.noteSpecialInstructions = noteSpecialInstructions;
	}

	/**
	 * @return the stopOffDetailContactGroup
	 */
	public Collection<StopOffDetailContactGroup> getStopOffDetailContactGroup() {
		return stopOffDetailContactGroup;
	}

	/**
	 * @param stopOffDetailContactGroup the stopOffDetailContactGroup to set
	 */
	public void setStopOffDetailContactGroup(Collection<StopOffDetailContactGroup> stopOffDetailContactGroup) {
		this.stopOffDetailContactGroup = stopOffDetailContactGroup;
	}

	/**
	 * @return the orderDetailGroup
	 */
	public Collection<OrderDetailGroup> getOrderDetailGroup() {
		return orderDetailGroup;
	}

	/**
	 * @param orderDetailGroup the orderDetailGroup to set
	 */
	public void setOrderDetailGroup(Collection<OrderDetailGroup> orderDetailGroup) {
		this.orderDetailGroup = orderDetailGroup;
	}

}
