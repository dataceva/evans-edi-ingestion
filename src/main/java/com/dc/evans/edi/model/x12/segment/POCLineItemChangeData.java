package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="POC")
public class POCLineItemChangeData {
	
	@EDIElement(fieldName="POC01", dataElement="350")
	@Size(min=1, max=20)
	private String assignedIdentifier; // Line number (USSCO system will truncate after 6 bytes).
	
	@EDIElement(fieldName="POC02", dataElement="670")
	@NotNull
	@Size(min=2, max=2)
	private String responseTypeCode;
	
	@EDIElement(fieldName="POC03", dataElement="330")
	private BigInteger quantityOrdered;
	
	@EDIElement(fieldName="POC04", dataElement="671")
	private BigInteger quantityLeftToRecieve;
	
	@EDIElement(fieldName="POC05", dataElement="C001")
	@NotNull
	private String unitOfMeasure;
	
	@EDIElement(fieldName="POC06", dataElement="212")
	@EDIElementFormat("####.##")
	private BigDecimal unitPrice;
	
	@EDIElement(fieldName="POC07", dataElement="639")
	@Size(min=2, max=2)
	private String basisUnitPriceCode;
	
	@EDIElement(fieldName="POC08", dataElement="235")
	@Size(min=2, max=2)
	private String prodServiceIDQualifier1;
	
	@EDIElement(fieldName="POC09", dataElement="234", conditional=true)//X?
	@Size(min=1, max=48)
	//@Size(min = 1, max = 48, groups={USSCO.class})
	private String prodServID1; // Your Item number
	
	@EDIElement(fieldName="POC10", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQual2; // 'VN'=vendor's item number
	
	@EDIElement(fieldName="POC11", dataElement="234", conditional=true)//X?
	@Size(min=1, max=48)
	//@Size(min = 1, max = 48, groups={USSCO.class})
	private String prodServID2; // USSCO�s item number

	@EDIElement(fieldName="POC12", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQual3;
	
	@EDIElement(fieldName="POC13", dataElement="234", conditional=true)//X?
	@Size(min=1, max=48)
	//@Size(min = 1, max = 48, groups={USSCO.class})
	private String prodServID3;

	/**
	 * @return the assignedIdentifier
	 */
	public String getAssignedIdentifier() {
		return assignedIdentifier;
	}

	/**
	 * @param assignedIdentifier the assignedIdentifier to set
	 */
	public void setAssignedIdentifier(String assignedIdentifier) {
		this.assignedIdentifier = assignedIdentifier;
	}

	/**
	 * @return the responseTypeCode
	 */
	public String getResponseTypeCode() {
		return responseTypeCode;
	}

	/**
	 * @param responseTypeCode the responseTypeCode to set
	 */
	public void setResponseTypeCode(String responseTypeCode) {
		this.responseTypeCode = responseTypeCode;
	}

	/**
	 * @return the quantityOrdered
	 */
	public BigInteger getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(BigInteger quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the quantityLeftToRecieve
	 */
	public BigInteger getQuantityLeftToRecieve() {
		return quantityLeftToRecieve;
	}

	/**
	 * @param quantityLeftToRecieve the quantityLeftToRecieve to set
	 */
	public void setQuantityLeftToRecieve(BigInteger quantityLeftToRecieve) {
		this.quantityLeftToRecieve = quantityLeftToRecieve;
	}

	/**
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the basisUnitPriceCode
	 */
	public String getBasisUnitPriceCode() {
		return basisUnitPriceCode;
	}

	/**
	 * @param basisUnitPriceCode the basisUnitPriceCode to set
	 */
	public void setBasisUnitPriceCode(String basisUnitPriceCode) {
		this.basisUnitPriceCode = basisUnitPriceCode;
	}

	/**
	 * @return the prodServiceIDQualifier1
	 */
	public String getProdServiceIDQualifier1() {
		return prodServiceIDQualifier1;
	}

	/**
	 * @param prodServiceIDQualifier1 the prodServiceIDQualifier1 to set
	 */
	public void setProdServiceIDQualifier1(String prodServiceIDQualifier1) {
		this.prodServiceIDQualifier1 = prodServiceIDQualifier1;
	}

	/**
	 * @return the prodServID1
	 */
	public String getProdServID1() {
		return prodServID1;
	}

	/**
	 * @param prodServID1 the prodServID1 to set
	 */
	public void setProdServID1(String prodServID1) {
		this.prodServID1 = prodServID1;
	}

	/**
	 * @return the prodServIDQual2
	 */
	public String getProdServIDQual2() {
		return prodServIDQual2;
	}

	/**
	 * @param prodServIDQual2 the prodServIDQual2 to set
	 */
	public void setProdServIDQual2(String prodServIDQual2) {
		this.prodServIDQual2 = prodServIDQual2;
	}

	/**
	 * @return the prodServID2
	 */
	public String getProdServID2() {
		return prodServID2;
	}

	/**
	 * @param prodServID2 the prodServID2 to set
	 */
	public void setProdServID2(String prodServID2) {
		this.prodServID2 = prodServID2;
	}

	/**
	 * @return the prodServIDQual3
	 */
	public String getProdServIDQual3() {
		return prodServIDQual3;
	}

	/**
	 * @param prodServIDQual3 the prodServIDQual3 to set
	 */
	public void setProdServIDQual3(String prodServIDQual3) {
		this.prodServIDQual3 = prodServIDQual3;
	}

	/**
	 * @return the prodServID3
	 */
	public String getProdServID3() {
		return prodServID3;
	}

	/**
	 * @param prodServID3 the prodServID3 to set
	 */
	public void setProdServID3(String prodServID3) {
		this.prodServID3 = prodServID3;
	}
	
	
}
