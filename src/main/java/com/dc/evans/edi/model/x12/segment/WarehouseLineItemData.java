package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="W01")
public class WarehouseLineItemData {
	@EDIElement(fieldName="W0101", dataElement="330")
	@Size(min=1, max=15)
	private Integer qtyOrdered;
	
	@EDIElement(fieldName="W0102", dataElement="355")
	@Size(min=2, max=2)
	private String uom;
	
	@EDIElement(fieldName="W0103", dataElement="438")
	@Size(min=12, max=12)
	private String upc;

	@EDIElement(fieldName="W0104", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier1;

	@EDIElement(fieldName="W0105", dataElement="234")
	@Size(min=1, max=30)
	private String productServiceID1;

	@EDIElement(fieldName="W0106", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier2;

	@EDIElement(fieldName="W0107", dataElement="234")
	@Size(min=1, max=30)
	private String productServiceID2;

	@EDIElement(fieldName="W0108", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier3;

	@EDIElement(fieldName="W0109", dataElement="234")
	@Size(min=1, max=30)
	private String productServiceID3;

	@EDIElement(fieldName="W0110", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier4;

	@EDIElement(fieldName="W0111", dataElement="234")
	@Size(min=1, max=30)
	private String productServiceID4;

	@EDIElement(fieldName="W0112", dataElement="235")
	@Size(min=2, max=2)
	private String productServiceIDQualifier5;

	@EDIElement(fieldName="W0113", dataElement="234")
	@Size(min=1, max=30)
	private String productServiceID5;

	/**
	 * @return the qtyOrdered
	 */
	public Integer getQtyOrdered() {
		return qtyOrdered;
	}

	/**
	 * @param qtyOrdered the qtyOrdered to set
	 */
	public void setQtyOrdered(Integer qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	/**
	 * @return the uom
	 */
	public String getUom() {
		return uom;
	}

	/**
	 * @param uom the uom to set
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}

	/**
	 * @return the upc
	 */
	public String getUpc() {
		return upc;
	}

	/**
	 * @param upc the upc to set
	 */
	public void setUpc(String upc) {
		this.upc = upc;
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
}
