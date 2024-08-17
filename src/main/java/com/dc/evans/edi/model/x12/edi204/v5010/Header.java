
package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.edi.IEDIMessageBodyHeader;
import com.dc.evans.edi.model.x12.segment.DateReference;
import com.dc.evans.edi.model.x12.segment.EquipmentDetail;
import com.dc.evans.edi.model.x12.segment.NoteSpecialInstructions;
import com.dc.evans.edi.model.x12.segment.TransactionSetHeader;

@EDISegmentGroup
public class Header implements IEDIMessageBodyHeader<Header>{

	@NotNull
	private TransactionSetHeader transactionSetHeader;
	
	@NotNull
	private ShipmentBeginningSegment beginningSegmentforInvoice;
	
	@NotNull
	private TransactionSetPurpose transactionSetPurpose;

	@EDICollectionType(BusinessInstruction.class)
	@Size(min=0, max=12)
	private Collection<BusinessInstruction> businessInstruction;
	
	@NotNull
	private DateReference dateReference;
	
	@NotNull
	private InterlineInformation interlineInformation;

	@EDICollectionType(BOLHandlingRequirement.class)
	@Size(min=0, max=200)
	private Collection<BOLHandlingRequirement> bolHandlingRequirement;
	
	@NotNull
	private PalletInformation palletInformation;
	
	@NotNull
	@Size(max=100000)
	@EDICollectionType(NoteSpecialInstructions.class)
	private Collection<NoteSpecialInstructions> noteSpecialInstructions;
	
	@Size(max=200)
	@EDICollectionType(ShippingBillingGroup.class)
	private Collection<ShippingBillingGroup> shippingBillingGroup;
	
	@Size(max=200)
	@EDICollectionType(EquipmentGroup.class)
	private Collection<EquipmentGroup> equipmentGroup;

	/**
	 * @return the transactionSetHeader
	 */
	public TransactionSetHeader getTransactionSetHeader() {
		return transactionSetHeader;
	}

	/**
	 * @param transactionSetHeader the transactionSetHeader to set
	 */
	public void setTransactionSetHeader(TransactionSetHeader transactionSetHeader) {
		this.transactionSetHeader = transactionSetHeader;
	}

	/**
	 * @return the beginningSegmentforInvoice
	 */
	public ShipmentBeginningSegment getBeginningSegmentforInvoice() {
		return beginningSegmentforInvoice;
	}

	/**
	 * @param beginningSegmentforInvoice the beginningSegmentforInvoice to set
	 */
	public void setBeginningSegmentforInvoice(ShipmentBeginningSegment beginningSegmentforInvoice) {
		this.beginningSegmentforInvoice = beginningSegmentforInvoice;
	}

	/**
	 * @return the transactionSetPurpose
	 */
	public TransactionSetPurpose getTransactionSetPurpose() {
		return transactionSetPurpose;
	}

	/**
	 * @param transactionSetPurpose the transactionSetPurpose to set
	 */
	public void setTransactionSetPurpose(TransactionSetPurpose transactionSetPurpose) {
		this.transactionSetPurpose = transactionSetPurpose;
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
	public DateReference getDateReference() {
		return dateReference;
	}

	/**
	 * @param dateReference the dateReference to set
	 */
	public void setDateReference(DateReference dateReference) {
		this.dateReference = dateReference;
	}

	/**
	 * @return the interlineInformation
	 */
	public InterlineInformation getInterlineInformation() {
		return interlineInformation;
	}

	/**
	 * @param interlineInformation the interlineInformation to set
	 */
	public void setInterlineInformation(InterlineInformation interlineInformation) {
		this.interlineInformation = interlineInformation;
	}

	/**
	 * @return the bolHandlingRequirement
	 */
	public Collection<BOLHandlingRequirement> getBolHandlingRequirement() {
		return bolHandlingRequirement;
	}

	/**
	 * @param bolHandlingRequirement the bolHandlingRequirement to set
	 */
	public void setBolHandlingRequirement(Collection<BOLHandlingRequirement> bolHandlingRequirement) {
		this.bolHandlingRequirement = bolHandlingRequirement;
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
	 * @return the shippingBillingGroup
	 */
	public Collection<ShippingBillingGroup> getShippingBillingGroup() {
		return shippingBillingGroup;
	}

	/**
	 * @param shippingBillingGroup the shippingBillingGroup to set
	 */
	public void setShippingBillingGroup(Collection<ShippingBillingGroup> shippingBillingGroup) {
		this.shippingBillingGroup = shippingBillingGroup;
	}

	/**
	 * @return the equipmentGroup
	 */
	public Collection<EquipmentGroup> getEquipmentGroup() {
		return equipmentGroup;
	}

	/**
	 * @param equipmentGroup the equipmentGroup to set
	 */
	public void setEquipmentGroup(Collection<EquipmentGroup> equipmentGroup) {
		this.equipmentGroup = equipmentGroup;
	}

}
