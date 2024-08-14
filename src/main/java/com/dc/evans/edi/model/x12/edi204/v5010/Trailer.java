package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;

import com.dc.evans.edi.model.x12.edi.IEDIMessageBodyTrailer;
import com.dc.evans.edi.model.x12.segment.TotalWeightAndChargeSummary;
import com.dc.evans.edi.model.x12.segment.TransactionSetTrailer;

@EDISegmentGroup
public class Trailer implements IEDIMessageBodyTrailer<Trailer> {

	@NotNull
	private TotalWeightAndChargeSummary totalWeightAndChargeSummary;
	
	@NotNull
	private TransactionSetTrailer transactionSetTrailer;

	/**
	 * @return the totalWeightAndChargeSummary
	 */
	public TotalWeightAndChargeSummary getTotalWeightAndChargeSummary() {
		return totalWeightAndChargeSummary;
	}

	/**
	 * @param totalWeightAndChargeSummary the totalWeightAndChargeSummary to set
	 */
	public void setTotalWeightAndChargeSummary(TotalWeightAndChargeSummary totalWeightAndChargeSummary) {
		this.totalWeightAndChargeSummary = totalWeightAndChargeSummary;
	}

	/**
	 * @return the transactionSetTrailer
	 */
	public TransactionSetTrailer getTransactionSetTrailer() {
		return transactionSetTrailer;
	}

	/**
	 * @param transactionSetTrailer the transactionSetTrailer to set
	 */
	public void setTransactionSetTrailer(TransactionSetTrailer transactionSetTrailer) {
		this.transactionSetTrailer = transactionSetTrailer;
	}

}
