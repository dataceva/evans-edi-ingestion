package com.dc.evans.edi.model.x12.edi204.v4010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;

@EDISegment(tag="PLD")
public class PalletInformation {
	
	@EDIElement(fieldName="PLD01",dataElement = "406")
	private Integer quantityOfPalletShipped;

	/**
	 * @return the quantityOfPalletShipped
	 */
	public Integer getQuantityOfPalletShipped() {
		return quantityOfPalletShipped;
	}

	/**
	 * @param quantityOfPalletShipped the quantityOfPalletShipped to set
	 */
	public void setQuantityOfPalletShipped(Integer quantityOfPalletShipped) {
		this.quantityOfPalletShipped = quantityOfPalletShipped;
	}

}
