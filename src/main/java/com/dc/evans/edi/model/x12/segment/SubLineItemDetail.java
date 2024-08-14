package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="SLN")
public class SubLineItemDetail {

	@EDIElement(fieldName="SLN01", dataElement="350")
	@NotNull
	@Size(min=1, max=20)
	private String assignedIdentification;
	
	@EDIElement(fieldName="SLN02", dataElement="350")
	@Size(min=1, max=20)
	private String assignedIndent;
	
	@EDIElement(fieldName="SLN03", dataElement="662")
	@Size(min=1, max=1)
	private String configurationCode;
	
	@EDIElement(fieldName="SLN04", dataElement="380")
	@Size(min=1, max=15)
	private Integer quantity;
	
	@EDIElement(fieldName="SLN05", dataElement="355")
	@Size(min=2, max=2)
	private String unitofMeasureCode;
	
	@EDIElement(fieldName="SLN06")
	@EDIElementFormat("####.##")
	private BigDecimal unitPrice;
	
	@EDIElement(fieldName="SLN07")
	@Size(min=2, max=2)
	private String basisOfUnitPriceCode;

	@EDIElement(fieldName="SLN08")
	@Size(min=1, max=1)
	private String relationshipCode;
	
	@EDIElement(fieldName="SLN09", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier1;
	
	@EDIElement(fieldName="SLN10", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID1;
	
	@EDIElement(fieldName="SLN11", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier2;
	
	@EDIElement(fieldName="SLN12", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID2;
	
	@EDIElement(fieldName="SLN13", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier3;
	
	@EDIElement(fieldName="SLN14", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID3;
	
	@EDIElement(fieldName="SLN15", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier4;
	
	@EDIElement(fieldName="SLN16", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID4;
	
	@EDIElement(fieldName="SLN17", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier5;
	
	@EDIElement(fieldName="SLN18", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID5;
	
	@EDIElement(fieldName="SLN19", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier6;
	
	@EDIElement(fieldName="SLN20", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID6;
	
	@EDIElement(fieldName="SLN21", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier7;
	
	@EDIElement(fieldName="SLN22", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID7;
	
	@EDIElement(fieldName="SLN23", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier8;
	
	@EDIElement(fieldName="SLN24", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID8;
	
	@EDIElement(fieldName="SLN25", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier9;
	
	@EDIElement(fieldName="SLN26", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID9;
	
	@EDIElement(fieldName="SLN27", dataElement="235")
	@Size(min=2, max=2)
	private String prodServIDQualifier10;
	
	@EDIElement(fieldName="SLN28", dataElement="234")
	@Size(min=1, max=48)
	private String prodServID10;

	public String getAssignedIdentification() {
		return assignedIdentification;
	}

	public void setAssignedIdentification(String assignedIdentification) {
		this.assignedIdentification = assignedIdentification;
	}

	public String getAssignedIndent() {
		return assignedIndent;
	}

	public void setAssignedIndent(String assignedIndent) {
		this.assignedIndent = assignedIndent;
	}

	public String getConfigurationCode() {
		return configurationCode;
	}

	public void setConfigurationCode(String configurationCode) {
		this.configurationCode = configurationCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnitofMeasureCode() {
		return unitofMeasureCode;
	}

	public void setUnitofMeasureCode(String unitofMeasureCode) {
		this.unitofMeasureCode = unitofMeasureCode;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getBasisOfUnitPriceCode() {
		return basisOfUnitPriceCode;
	}

	public void setBasisOfUnitPriceCode(String basisOfUnitPriceCode) {
		this.basisOfUnitPriceCode = basisOfUnitPriceCode;
	}

	public String getRelationshipCode() {
		return relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getProdServIDQualifier1() {
		return prodServIDQualifier1;
	}

	public void setProdServIDQualifier1(String prodServIDQualifier1) {
		this.prodServIDQualifier1 = prodServIDQualifier1;
	}

	public String getProdServID1() {
		return prodServID1;
	}

	public void setProdServID1(String prodServID1) {
		this.prodServID1 = prodServID1;
	}

	public String getProdServIDQualifier2() {
		return prodServIDQualifier2;
	}

	public void setProdServIDQualifier2(String prodServIDQualifier2) {
		this.prodServIDQualifier2 = prodServIDQualifier2;
	}

	public String getProdServID2() {
		return prodServID2;
	}

	public void setProdServID2(String prodServID2) {
		this.prodServID2 = prodServID2;
	}

	public String getProdServIDQualifier3() {
		return prodServIDQualifier3;
	}

	public void setProdServIDQualifier3(String prodServIDQualifier3) {
		this.prodServIDQualifier3 = prodServIDQualifier3;
	}

	public String getProdServID3() {
		return prodServID3;
	}

	public void setProdServID3(String prodServID3) {
		this.prodServID3 = prodServID3;
	}

	public String getProdServIDQualifier4() {
		return prodServIDQualifier4;
	}

	public void setProdServIDQualifier4(String prodServIDQualifier4) {
		this.prodServIDQualifier4 = prodServIDQualifier4;
	}

	public String getProdServID4() {
		return prodServID4;
	}

	public void setProdServID4(String prodServID4) {
		this.prodServID4 = prodServID4;
	}

	public String getProdServIDQualifier5() {
		return prodServIDQualifier5;
	}

	public void setProdServIDQualifier5(String prodServIDQualifier5) {
		this.prodServIDQualifier5 = prodServIDQualifier5;
	}

	public String getProdServID5() {
		return prodServID5;
	}

	public void setProdServID5(String prodServID5) {
		this.prodServID5 = prodServID5;
	}

	/**
	 * @return the prodServIDQualifier6
	 */
	public String getProdServIDQualifier6() {
		return prodServIDQualifier6;
	}

	/**
	 * @param prodServIDQualifier6 the prodServIDQualifier6 to set
	 */
	public void setProdServIDQualifier6(String prodServIDQualifier6) {
		this.prodServIDQualifier6 = prodServIDQualifier6;
	}

	/**
	 * @return the prodServID6
	 */
	public String getProdServID6() {
		return prodServID6;
	}

	/**
	 * @param prodServID6 the prodServID6 to set
	 */
	public void setProdServID6(String prodServID6) {
		this.prodServID6 = prodServID6;
	}

	/**
	 * @return the prodServIDQualifier7
	 */
	public String getProdServIDQualifier7() {
		return prodServIDQualifier7;
	}

	/**
	 * @param prodServIDQualifier7 the prodServIDQualifier7 to set
	 */
	public void setProdServIDQualifier7(String prodServIDQualifier7) {
		this.prodServIDQualifier7 = prodServIDQualifier7;
	}

	/**
	 * @return the prodServID7
	 */
	public String getProdServID7() {
		return prodServID7;
	}

	/**
	 * @param prodServID7 the prodServID7 to set
	 */
	public void setProdServID7(String prodServID7) {
		this.prodServID7 = prodServID7;
	}

	/**
	 * @return the prodServIDQualifier8
	 */
	public String getProdServIDQualifier8() {
		return prodServIDQualifier8;
	}

	/**
	 * @param prodServIDQualifier8 the prodServIDQualifier8 to set
	 */
	public void setProdServIDQualifier8(String prodServIDQualifier8) {
		this.prodServIDQualifier8 = prodServIDQualifier8;
	}

	/**
	 * @return the prodServID8
	 */
	public String getProdServID8() {
		return prodServID8;
	}

	/**
	 * @param prodServID8 the prodServID8 to set
	 */
	public void setProdServID8(String prodServID8) {
		this.prodServID8 = prodServID8;
	}

	/**
	 * @return the prodServIDQualifier9
	 */
	public String getProdServIDQualifier9() {
		return prodServIDQualifier9;
	}

	/**
	 * @param prodServIDQualifier9 the prodServIDQualifier9 to set
	 */
	public void setProdServIDQualifier9(String prodServIDQualifier9) {
		this.prodServIDQualifier9 = prodServIDQualifier9;
	}

	/**
	 * @return the prodServID9
	 */
	public String getProdServID9() {
		return prodServID9;
	}

	/**
	 * @param prodServID9 the prodServID9 to set
	 */
	public void setProdServID9(String prodServID9) {
		this.prodServID9 = prodServID9;
	}

	/**
	 * @return the prodServIDQualifier10
	 */
	public String getProdServIDQualifier10() {
		return prodServIDQualifier10;
	}

	/**
	 * @param prodServIDQualifier10 the prodServIDQualifier10 to set
	 */
	public void setProdServIDQualifier10(String prodServIDQualifier10) {
		this.prodServIDQualifier10 = prodServIDQualifier10;
	}

	/**
	 * @return the prodServID10
	 */
	public String getProdServID10() {
		return prodServID10;
	}

	/**
	 * @param prodServID10 the prodServID10 to set
	 */
	public void setProdServID10(String prodServID10) {
		this.prodServID10 = prodServID10;
	}

	
}
