package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="MS3")
public class InterlineInformation {

	@EDIElement(fieldName="MS301", dataElement="140")
	@Size(min=1,max=2)
	private String carrierCode;
	
	@EDIElement(fieldName="MS302", dataElement="133")
	@Size(min=1,max=4)
	private String routingSequenceCode;
	
	@EDIElement(fieldName="MS304", dataElement="91")
	@Size(min=1,max=10)
	private String transportationMethod;

	/**
	 * @return the carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * @param carrierCode the carrierCode to set
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	/**
	 * @return the routingSequenceCode
	 */
	public String getRoutingSequenceCode() {
		return routingSequenceCode;
	}

	/**
	 * @param routingSequenceCode the routingSequenceCode to set
	 */
	public void setRoutingSequenceCode(String routingSequenceCode) {
		this.routingSequenceCode = routingSequenceCode;
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
}
