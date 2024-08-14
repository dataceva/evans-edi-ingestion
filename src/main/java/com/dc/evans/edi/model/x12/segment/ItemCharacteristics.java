package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="G55")
public class ItemCharacteristics {
	@EDIElement(fieldName="G5501", dataElement="350")
	@Size(min=1, max=20)
	private String assignedIdentificationNumber;
	
	@EDIElement(fieldName="G5502", dataElement="235")
	@NotNull
	@Size(min=2, max=2)
	private String productServiceIDQualifier1;
	
	@EDIElement(fieldName="G5503", dataElement="234")
	@NotNull
	@Size(min=1, max=15)
	private String productServiceID1;
	
	@EDIElement(fieldName="G5504", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier2;
	
	@EDIElement(fieldName="G5505", dataElement="234")
	@Size(min=1, max=8)
	private String itemHeight;
	
	@EDIElement(fieldName="G5506", dataElement="235")
	@Size(min=2, max=2)
	private String itemHeightUOM;
	
	@EDIElement(fieldName="G5507", dataElement="234")
	@Size(min=1, max=15)
	private String itemWidth;
	
	@EDIElement(fieldName="G5508", dataElement="235")
	@Size(min=2, max=2)
	private String itemWidthUOM;
	
	@EDIElement(fieldName="G5509", dataElement="234")
	@Size(min=1, max=15)
	private String itemLength;
	
	@EDIElement(fieldName="G5510", dataElement="235")
	@Size(min=2, max=2)
	private String itemLengthUOM;
	
	@EDIElement(fieldName="G5511", dataElement="234")
	@Size(min=1, max=12)
	private String itemCubic;
	
	@EDIElement(fieldName="G5512", dataElement="235")
	@Size(min=2, max=2)
	private String itemCubicUOM;
	
	@EDIElement(fieldName="G5513", dataElement="234")
	@Size(min=1, max=15)
	private String innerPackQty;
	
	@EDIElement(fieldName="G5514", dataElement="235")
	@Size(min=1, max=2)
	private String caseQty;
	
	@EDIElement(fieldName="G5515", dataElement="235")
	@Size(min=2, max=2)
	private String caseQtyUom;
	
	@EDIElement(fieldName="G5516", dataElement="235")
	private String cashRegisterItemDesc1;
	
	@EDIElement(fieldName="G5517", dataElement="235")
	private String cashRegisterItemDesc2;
	
	@EDIElement(fieldName="G5518", dataElement="235")
	private String couponFamilyCode;
	
	@EDIElement(fieldName="G5519", dataElement="235")
	private String datedProductNoOfDay;
	
	@EDIElement(fieldName="G5520", dataElement="235")
	private BigDecimal depositValue;
	
	@EDIElement(fieldName="G5521", dataElement="235")
	private BigDecimal responseCode;
	
	@EDIElement(fieldName="G5522", dataElement="235")
	private BigDecimal color;
	
	@EDIElement(fieldName="G5523", dataElement="234")
	@Size(min=1, max=15)
	private String caseWeight;
	
	@EDIElement(fieldName="G5524", dataElement="234")
	@Size(min=1, max=15)
	private String weightQualifier;
	
	@EDIElement(fieldName="G5525", dataElement="234")
	@Size(min=1, max=15)
	private String weightUOM;

	/**
	 * @return the assignedIdentificationNumber
	 */
	public String getAssignedIdentificationNumber() {
		return assignedIdentificationNumber;
	}

	/**
	 * @param assignedIdentificationNumber the assignedIdentificationNumber to set
	 */
	public void setAssignedIdentificationNumber(String assignedIdentificationNumber) {
		this.assignedIdentificationNumber = assignedIdentificationNumber;
	}

	/**
	 * @return the productServiceIDQualifier1
	 */
	public String getProductServiceIDQualifier1() {
		return productServiceIDQualifier1;
	}

	/**
	 * @param productServiceIDQualifier1 the productServiceIDQualifier1 to set
	 */
	public void setProductServiceIDQualifier1(String productServiceIDQualifier1) {
		this.productServiceIDQualifier1 = productServiceIDQualifier1;
	}

	/**
	 * @return the productServiceID1
	 */
	public String getProductServiceID1() {
		return productServiceID1;
	}

	/**
	 * @param productServiceID1 the productServiceID1 to set
	 */
	public void setProductServiceID1(String productServiceID1) {
		this.productServiceID1 = productServiceID1;
	}

	/**
	 * @return the productServiceIDQualifier2
	 */
	public String getProductServiceIDQualifier2() {
		return productServiceIDQualifier2;
	}

	/**
	 * @param productServiceIDQualifier2 the productServiceIDQualifier2 to set
	 */
	public void setProductServiceIDQualifier2(String productServiceIDQualifier2) {
		this.productServiceIDQualifier2 = productServiceIDQualifier2;
	}

	/**
	 * @return the itemHeight
	 */
	public String getItemHeight() {
		return itemHeight;
	}

	/**
	 * @param itemHeight the itemHeight to set
	 */
	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	/**
	 * @return the itemHeightUOM
	 */
	public String getItemHeightUOM() {
		return itemHeightUOM;
	}

	/**
	 * @param itemHeightUOM the itemHeightUOM to set
	 */
	public void setItemHeightUOM(String itemHeightUOM) {
		this.itemHeightUOM = itemHeightUOM;
	}

	/**
	 * @return the itemWidth
	 */
	public String getItemWidth() {
		return itemWidth;
	}

	/**
	 * @param itemWidth the itemWidth to set
	 */
	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	/**
	 * @return the itemWidthUOM
	 */
	public String getItemWidthUOM() {
		return itemWidthUOM;
	}

	/**
	 * @param itemWidthUOM the itemWidthUOM to set
	 */
	public void setItemWidthUOM(String itemWidthUOM) {
		this.itemWidthUOM = itemWidthUOM;
	}

	/**
	 * @return the itemLength
	 */
	public String getItemLength() {
		return itemLength;
	}

	/**
	 * @param itemLength the itemLength to set
	 */
	public void setItemLength(String itemLength) {
		this.itemLength = itemLength;
	}

	/**
	 * @return the itemLengthUOM
	 */
	public String getItemLengthUOM() {
		return itemLengthUOM;
	}

	/**
	 * @param itemLengthUOM the itemLengthUOM to set
	 */
	public void setItemLengthUOM(String itemLengthUOM) {
		this.itemLengthUOM = itemLengthUOM;
	}

	/**
	 * @return the itemCubic
	 */
	public String getItemCubic() {
		return itemCubic;
	}

	/**
	 * @param itemCubic the itemCubic to set
	 */
	public void setItemCubic(String itemCubic) {
		this.itemCubic = itemCubic;
	}

	/**
	 * @return the itemCubicUOM
	 */
	public String getItemCubicUOM() {
		return itemCubicUOM;
	}

	/**
	 * @param itemCubicUOM the itemCubicUOM to set
	 */
	public void setItemCubicUOM(String itemCubicUOM) {
		this.itemCubicUOM = itemCubicUOM;
	}

	/**
	 * @return the innerPackQty
	 */
	public String getInnerPackQty() {
		return innerPackQty;
	}

	/**
	 * @param innerPackQty the innerPackQty to set
	 */
	public void setInnerPackQty(String innerPackQty) {
		this.innerPackQty = innerPackQty;
	}

	/**
	 * @return the caseQty
	 */
	public String getCaseQty() {
		return caseQty;
	}

	/**
	 * @param caseQty the caseQty to set
	 */
	public void setCaseQty(String caseQty) {
		this.caseQty = caseQty;
	}

	/**
	 * @return the caseWeight
	 */
	public String getCaseWeight() {
		return caseWeight;
	}

	/**
	 * @param caseWeight the caseWeight to set
	 */
	public void setCaseWeight(String caseWeight) {
		this.caseWeight = caseWeight;
	}

	/**
	 * @return the weightQualifier
	 */
	public String getWeightQualifier() {
		return weightQualifier;
	}

	/**
	 * @param weightQualifier the weightQualifier to set
	 */
	public void setWeightQualifier(String weightQualifier) {
		this.weightQualifier = weightQualifier;
	}

	/**
	 * @return the weightUOM
	 */
	public String getWeightUOM() {
		return weightUOM;
	}

	/**
	 * @param weightUOM the weightUOM to set
	 */
	public void setWeightUOM(String weightUOM) {
		this.weightUOM = weightUOM;
	}

	/**
	 * @return the caseQtyUom
	 */
	public String getCaseQtyUom() {
		return caseQtyUom;
	}

	/**
	 * @param caseQtyUom the caseQtyUom to set
	 */
	public void setCaseQtyUom(String caseQtyUom) {
		this.caseQtyUom = caseQtyUom;
	}

	/**
	 * @return the cashRegisterItemDesc1
	 */
	public String getCashRegisterItemDesc1() {
		return cashRegisterItemDesc1;
	}

	/**
	 * @param cashRegisterItemDesc1 the cashRegisterItemDesc1 to set
	 */
	public void setCashRegisterItemDesc1(String cashRegisterItemDesc1) {
		this.cashRegisterItemDesc1 = cashRegisterItemDesc1;
	}

	/**
	 * @return the cashRegisterItemDesc2
	 */
	public String getCashRegisterItemDesc2() {
		return cashRegisterItemDesc2;
	}

	/**
	 * @param cashRegisterItemDesc2 the cashRegisterItemDesc2 to set
	 */
	public void setCashRegisterItemDesc2(String cashRegisterItemDesc2) {
		this.cashRegisterItemDesc2 = cashRegisterItemDesc2;
	}

	/**
	 * @return the couponFamilyCode
	 */
	public String getCouponFamilyCode() {
		return couponFamilyCode;
	}

	/**
	 * @param couponFamilyCode the couponFamilyCode to set
	 */
	public void setCouponFamilyCode(String couponFamilyCode) {
		this.couponFamilyCode = couponFamilyCode;
	}

	/**
	 * @return the datedProductNoOfDay
	 */
	public String getDatedProductNoOfDay() {
		return datedProductNoOfDay;
	}

	/**
	 * @param datedProductNoOfDay the datedProductNoOfDay to set
	 */
	public void setDatedProductNoOfDay(String datedProductNoOfDay) {
		this.datedProductNoOfDay = datedProductNoOfDay;
	}

	/**
	 * @return the depositValue
	 */
	public BigDecimal getDepositValue() {
		return depositValue;
	}

	/**
	 * @param depositValue the depositValue to set
	 */
	public void setDepositValue(BigDecimal depositValue) {
		this.depositValue = depositValue;
	}

	/**
	 * @return the responseCode
	 */
	public BigDecimal getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(BigDecimal responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the color
	 */
	public BigDecimal getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(BigDecimal color) {
		this.color = color;
	}
}
