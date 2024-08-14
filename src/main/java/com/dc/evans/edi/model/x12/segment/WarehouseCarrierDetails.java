package com.dc.evans.edi.model.x12.segment;

import java.math.BigInteger;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="W66")
public class WarehouseCarrierDetails {
	@Size(min=2, max=2)
	@EDIElement(fieldName="W6601", dataElement="146")
	private String paymentMethod;
	
	@Size(min=1, max=2)
	@EDIElement(fieldName="W6602", dataElement="91")
	private String transportationMethod;
	
	@EDIElement(fieldName="W6603", dataElement="399")
	@Size(min=2, max=1)
	private String palletExcahngeCode;
	
	@EDIElement(fieldName="W6604", dataElement="400")
	@Size(min=2, max=2)
	private String unitLoadCode;
	
	@EDIElement(fieldName="W6605", dataElement="387")
	@Size(min=1, max=35)
	private String routing;
	
	@Size(min = 2, max = 2)
	@EDIElement(fieldName="W6606",dataElement="433")
	private String fobPointCode; 
	
	@Size(min = 1, max = 30)
	@EDIElement(fieldName="W6607",dataElement="434")
	private String fob; 
	
	@Size(min = 1, max = 1)
	@EDIElement(fieldName="W6608",dataElement="625")
	private String codPaymentMethod; 
	
	@Size(min = 1, max = 15)
	@EDIElement(fieldName="W6609",dataElement="610")
	private BigInteger amount; 
	
	@Size(min = 2, max = 4)
	@EDIElement(fieldName="W6610",dataElement="140")
	private String scac;

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the transportationMethod
	 */
	public String getTransportationMethod() {
		return transportationMethod;
	}

	/**
	 * @param transportationMethod the transportationMethod to set
	 */
	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}

	/**
	 * @return the palletExcahngeCode
	 */
	public String getPalletExcahngeCode() {
		return palletExcahngeCode;
	}

	/**
	 * @param palletExcahngeCode the palletExcahngeCode to set
	 */
	public void setPalletExcahngeCode(String palletExcahngeCode) {
		this.palletExcahngeCode = palletExcahngeCode;
	}

	/**
	 * @return the unitLoadCode
	 */
	public String getUnitLoadCode() {
		return unitLoadCode;
	}

	/**
	 * @param unitLoadCode the unitLoadCode to set
	 */
	public void setUnitLoadCode(String unitLoadCode) {
		this.unitLoadCode = unitLoadCode;
	}

	/**
	 * @return the routing
	 */
	public String getRouting() {
		return routing;
	}

	/**
	 * @param routing the routing to set
	 */
	public void setRouting(String routing) {
		this.routing = routing;
	}

	/**
	 * @return the fobPointCode
	 */
	public String getFobPointCode() {
		return fobPointCode;
	}

	/**
	 * @param fobPointCode the fobPointCode to set
	 */
	public void setFobPointCode(String fobPointCode) {
		this.fobPointCode = fobPointCode;
	}

	/**
	 * @return the fob
	 */
	public String getFob() {
		return fob;
	}

	/**
	 * @param fob the fob to set
	 */
	public void setFob(String fob) {
		this.fob = fob;
	}

	/**
	 * @return the codPaymentMethod
	 */
	public String getCodPaymentMethod() {
		return codPaymentMethod;
	}

	/**
	 * @param codPaymentMethod the codPaymentMethod to set
	 */
	public void setCodPaymentMethod(String codPaymentMethod) {
		this.codPaymentMethod = codPaymentMethod;
	}

	/**
	 * @return the amount
	 */
	public BigInteger getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	/**
	 * @return the scac
	 */
	public String getScac() {
		return scac;
	}

	/**
	 * @param scac the scac to set
	 */
	public void setScac(String scac) {
		this.scac = scac;
	} 
}
