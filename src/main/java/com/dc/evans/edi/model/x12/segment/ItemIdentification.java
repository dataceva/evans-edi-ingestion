package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="LIN")
public class ItemIdentification {
	@EDIElement(fieldName="LIN01", dataElement="350")
	@Size(min=1, max=20)
	private String assignedIdentificationNumber;
	
	@EDIElement(fieldName="LIN02", dataElement="235")
	@NotNull
	@Size(min=2, max=2)
	private String productServiceIDQualifier1;
	
	@EDIElement(fieldName="LIN03", dataElement="234")
	@NotNull
	@Size(min=1, max=15)
	private String productServiceID1;
	
	@EDIElement(fieldName="LIN04", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier2;
	
	@EDIElement(fieldName="LIN05", dataElement="234")
	@Size(min=1, max=12)
	private String productServiceID2;
	
	@EDIElement(fieldName="LIN06", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier3;
	
	@EDIElement(fieldName="LIN07", dataElement="234")
	@Size(min=1, max=15)
	private String productServiceID3;
	
	@EDIElement(fieldName="LIN08", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier4;
	
	@EDIElement(fieldName="LIN09", dataElement="234")
	@Size(min=1, max=15)
	private String productServiceID4;
	
	@EDIElement(fieldName="LIN10", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier5;
	
	@EDIElement(fieldName="LIN11", dataElement="234")
	@Size(min=1, max=12)
	private String productServiceID5;
	
	@EDIElement(fieldName="LIN12", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier6;
	
	@EDIElement(fieldName="LIN13", dataElement="234")
	@Size(min=1, max=15)
	private String productServiceID6;
	
	@EDIElement(fieldName="LIN14", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier7;
	
	@EDIElement(fieldName="LIN15", dataElement="234")
	@Size(min=1, max=15)
	private String productServiceID7;

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
	 * @return the productServiceID2
	 */
	public String getProductServiceID2() {
		return productServiceID2;
	}

	/**
	 * @param productServiceID2 the productServiceID2 to set
	 */
	public void setProductServiceID2(String productServiceID2) {
		this.productServiceID2 = productServiceID2;
	}

	/**
	 * @return the productServiceIDQualifier3
	 */
	public String getProductServiceIDQualifier3() {
		return productServiceIDQualifier3;
	}

	/**
	 * @param productServiceIDQualifier3 the productServiceIDQualifier3 to set
	 */
	public void setProductServiceIDQualifier3(String productServiceIDQualifier3) {
		this.productServiceIDQualifier3 = productServiceIDQualifier3;
	}

	/**
	 * @return the productServiceID3
	 */
	public String getProductServiceID3() {
		return productServiceID3;
	}

	/**
	 * @param productServiceID3 the productServiceID3 to set
	 */
	public void setProductServiceID3(String productServiceID3) {
		this.productServiceID3 = productServiceID3;
	}

	/**
	 * @return the productServiceIDQualifier4
	 */
	public String getProductServiceIDQualifier4() {
		return productServiceIDQualifier4;
	}

	/**
	 * @param productServiceIDQualifier4 the productServiceIDQualifier4 to set
	 */
	public void setProductServiceIDQualifier4(String productServiceIDQualifier4) {
		this.productServiceIDQualifier4 = productServiceIDQualifier4;
	}

	/**
	 * @return the productServiceID4
	 */
	public String getProductServiceID4() {
		return productServiceID4;
	}

	/**
	 * @param productServiceID4 the productServiceID4 to set
	 */
	public void setProductServiceID4(String productServiceID4) {
		this.productServiceID4 = productServiceID4;
	}

	/**
	 * @return the productServiceIDQualifier5
	 */
	public String getProductServiceIDQualifier5() {
		return productServiceIDQualifier5;
	}

	/**
	 * @param productServiceIDQualifier5 the productServiceIDQualifier5 to set
	 */
	public void setProductServiceIDQualifier5(String productServiceIDQualifier5) {
		this.productServiceIDQualifier5 = productServiceIDQualifier5;
	}

	/**
	 * @return the productServiceID5
	 */
	public String getProductServiceID5() {
		return productServiceID5;
	}

	/**
	 * @param productServiceID5 the productServiceID5 to set
	 */
	public void setProductServiceID5(String productServiceID5) {
		this.productServiceID5 = productServiceID5;
	}

	/**
	 * @return the productServiceIDQualifier6
	 */
	public String getProductServiceIDQualifier6() {
		return productServiceIDQualifier6;
	}

	/**
	 * @param productServiceIDQualifier6 the productServiceIDQualifier6 to set
	 */
	public void setProductServiceIDQualifier6(String productServiceIDQualifier6) {
		this.productServiceIDQualifier6 = productServiceIDQualifier6;
	}

	/**
	 * @return the productServiceID6
	 */
	public String getProductServiceID6() {
		return productServiceID6;
	}

	/**
	 * @param productServiceID6 the productServiceID6 to set
	 */
	public void setProductServiceID6(String productServiceID6) {
		this.productServiceID6 = productServiceID6;
	}

	/**
	 * @return the productServiceIDQualifier7
	 */
	public String getProductServiceIDQualifier7() {
		return productServiceIDQualifier7;
	}

	/**
	 * @param productServiceIDQualifier7 the productServiceIDQualifier7 to set
	 */
	public void setProductServiceIDQualifier7(String productServiceIDQualifier7) {
		this.productServiceIDQualifier7 = productServiceIDQualifier7;
	}

	/**
	 * @return the productServiceID7
	 */
	public String getProductServiceID7() {
		return productServiceID7;
	}

	/**
	 * @param productServiceID7 the productServiceID7 to set
	 */
	public void setProductServiceID7(String productServiceID7) {
		this.productServiceID7 = productServiceID7;
	}
	
	
}
