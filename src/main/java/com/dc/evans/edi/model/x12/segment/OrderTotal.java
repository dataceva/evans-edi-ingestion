package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;

@EDISegment(tag="AMT")
public class OrderTotal {

	@EDIElement(fieldName="AMT01", dataElement="354")
	private String code;

	@EDIElement(fieldName="AMT02", dataElement="347")
	@EDIElementFormat("####.##")
	private BigDecimal hashTotal;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the hashTotal
	 */
	public BigDecimal getHashTotal() {
		return hashTotal;
	}

	/**
	 * @param hashTotal the hashTotal to set
	 */
	public void setHashTotal(BigDecimal hashTotal) {
		this.hashTotal = hashTotal;
	}


}
