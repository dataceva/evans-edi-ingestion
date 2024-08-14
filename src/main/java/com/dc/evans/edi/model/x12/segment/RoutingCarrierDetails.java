package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="TD5")
public class RoutingCarrierDetails {

	@Size(min=1, max=2)
	@EDIElement(fieldName="TD501", dataElement="133")
	private String routingSequenceCode;
	
	@Size(min=1, max=2)
	@EDIElement(fieldName="TD502", dataElement="66")
	private String identificationCodeQualifier;
	
	@EDIElement(fieldName="TD503", dataElement="67")
	@Size(min=2, max=80)
	private String identificationCode;
	
	@EDIElement(fieldName="TD504", dataElement="91")
	@Size(min=1, max=2)
	private String transportationMethod;
	
	@EDIElement(fieldName="TD505", dataElement="387")
	@Size(min=1, max=35)
	private String routing;
	
	@Size(min = 2, max = 2)
	@EDIElement(fieldName="TD506",dataElement="368",conditional=true)
	private String shipmentOrderStatusCode; 
	
	@Size(min = 2, max = 2)
	@EDIElement(fieldName="TD512",dataElement="284",conditional=true)
	private String serviceLevelCode;

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
	 * @return the identificationCodeQualifier
	 */
	public String getIdentificationCodeQualifier() {
		return identificationCodeQualifier;
	}

	/**
	 * @param identificationCodeQualifier the identificationCodeQualifier to set
	 */
	public void setIdentificationCodeQualifier(String identificationCodeQualifier) {
		this.identificationCodeQualifier = identificationCodeQualifier;
	}

	/**
	 * @return the identificationCode
	 */
	public String getIdentificationCode() {
		return identificationCode;
	}

	/**
	 * @param identificationCode the identificationCode to set
	 */
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
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
	 * @return the shipmentOrderStatusCode
	 */
	public String getShipmentOrderStatusCode() {
		return shipmentOrderStatusCode;
	}

	/**
	 * @param shipmentOrderStatusCode the shipmentOrderStatusCode to set
	 */
	public void setShipmentOrderStatusCode(String shipmentOrderStatusCode) {
		this.shipmentOrderStatusCode = shipmentOrderStatusCode;
	}

	/**
	 * @return the serviceLevelCode
	 */
	public String getServiceLevelCode() {
		return serviceLevelCode;
	}

	/**
	 * @param serviceLevelCode the serviceLevelCode to set
	 */
	public void setServiceLevelCode(String serviceLevelCode) {
		this.serviceLevelCode = serviceLevelCode;
	} 

}
