package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="N7")
public class EquipmentDetail {

	@EDIElement(fieldName="N701", dataElement="206")
	@Size(min=1,max=4)
	private String equipmentInitial;

	@EDIElement(fieldName="N702", dataElement="207")
	@Size(min=1,max=10)
	private String equipmentNumber;

	@EDIElement(fieldName="N703", dataElement="81")
	private Double weight;

	@EDIElement(fieldName="N704", dataElement="207")
	@Size(min=1,max=10)
	private String weightQualifier;

	@EDIElement(fieldName="N705", dataElement="167")
	@Size(min=1,max=10)
	private String tareWeight;

	@EDIElement(fieldName="N706", dataElement="232")
	@Size(min=1,max=10)
	private String weightAllowance;

	@EDIElement(fieldName="N707", dataElement="205")
	@Size(min=1,max=10)
	private String dunnage;

	@EDIElement(fieldName="N708", dataElement="183")
	@Size(min=1,max=10)
	private String volume;

	@EDIElement(fieldName="N709", dataElement="184")
	@Size(min=1,max=10)
	private String volumeUOM;

	@EDIElement(fieldName="N710", dataElement="184")
	@Size(min=1,max=10)
	private String ownershipCode;
	
	@EDIElement(fieldName="N711", dataElement="40")
	@Size(min=2,max=2)
	private String equipmentCode;
	
	@EDIElement(fieldName="N712", dataElement="140")
	@Size(min=2,max=2)
	private String scac;
	
	@EDIElement(fieldName="N713", dataElement="319")
	@Size(min=2,max=2)
	private String temperatureControl;
	
	@EDIElement(fieldName="N714", dataElement="319")
	@Size(min=2,max=2)
	private String position;
	
	@EDIElement(fieldName="N715", dataElement="206")
	@Size(min=1,max=4)
	private String equipmentLength;
	
	@EDIElement(fieldName="N716", dataElement="206")
	@Size(min=1,max=4)
	private String tareQualifierCode;
	
	@EDIElement(fieldName="N717", dataElement="206")
	@Size(min=1,max=4)
	private String weightUOM;

	@EDIElement(fieldName="N718", dataElement="207")
	private Integer equipmentNumberCheckDigit;

	@EDIElement(fieldName="N719", dataElement="207")
	private String serviceCodeType;

	@EDIElement(fieldName="N720", dataElement="207")
	private String height;

	@EDIElement(fieldName="N721", dataElement="207")
	private String width;
	
	@EDIElement(fieldName="N722", dataElement="225")
	@Size(min=2,max=15)
	private String equipmentType;
	
	/**
	 * @return the equipmentNumber
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	/**
	 * @param equipmentNumber the equipmentNumber to set
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	/**
	 * @return the equipmentCode
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * @param equipmentCode the equipmentCode to set
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	/**
	 * @return the equipmentLength
	 */
	public String getEquipmentLength() {
		return equipmentLength;
	}

	/**
	 * @param equipmentLength the equipmentLength to set
	 */
	public void setEquipmentLength(String equipmentLength) {
		this.equipmentLength = equipmentLength;
	}

	/**
	 * @return the equipmentType
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * @param equipmentType the equipmentType to set
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	/**
	 * @return the equipmentInitial
	 */
	public String getEquipmentInitial() {
		return equipmentInitial;
	}

	/**
	 * @param equipmentInitial the equipmentInitial to set
	 */
	public void setEquipmentInitial(String equipmentInitial) {
		this.equipmentInitial = equipmentInitial;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
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
	 * @return the tareWeight
	 */
	public String getTareWeight() {
		return tareWeight;
	}

	/**
	 * @param tareWeight the tareWeight to set
	 */
	public void setTareWeight(String tareWeight) {
		this.tareWeight = tareWeight;
	}

	/**
	 * @return the weightAllowance
	 */
	public String getWeightAllowance() {
		return weightAllowance;
	}

	/**
	 * @param weightAllowance the weightAllowance to set
	 */
	public void setWeightAllowance(String weightAllowance) {
		this.weightAllowance = weightAllowance;
	}

	/**
	 * @return the dunnage
	 */
	public String getDunnage() {
		return dunnage;
	}

	/**
	 * @param dunnage the dunnage to set
	 */
	public void setDunnage(String dunnage) {
		this.dunnage = dunnage;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the volumeUOM
	 */
	public String getVolumeUOM() {
		return volumeUOM;
	}

	/**
	 * @param volumeUOM the volumeUOM to set
	 */
	public void setVolumeUOM(String volumeUOM) {
		this.volumeUOM = volumeUOM;
	}

	/**
	 * @return the ownershipCode
	 */
	public String getOwnershipCode() {
		return ownershipCode;
	}

	/**
	 * @param ownershipCode the ownershipCode to set
	 */
	public void setOwnershipCode(String ownershipCode) {
		this.ownershipCode = ownershipCode;
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

	/**
	 * @return the temperatureControl
	 */
	public String getTemperatureControl() {
		return temperatureControl;
	}

	/**
	 * @param temperatureControl the temperatureControl to set
	 */
	public void setTemperatureControl(String temperatureControl) {
		this.temperatureControl = temperatureControl;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the tareQualifierCode
	 */
	public String getTareQualifierCode() {
		return tareQualifierCode;
	}

	/**
	 * @param tareQualifierCode the tareQualifierCode to set
	 */
	public void setTareQualifierCode(String tareQualifierCode) {
		this.tareQualifierCode = tareQualifierCode;
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
	 * @return the equipmentNumberCheckDigit
	 */
	public Integer getEquipmentNumberCheckDigit() {
		return equipmentNumberCheckDigit;
	}

	/**
	 * @param equipmentNumberCheckDigit the equipmentNumberCheckDigit to set
	 */
	public void setEquipmentNumberCheckDigit(Integer equipmentNumberCheckDigit) {
		this.equipmentNumberCheckDigit = equipmentNumberCheckDigit;
	}

	/**
	 * @return the serviceCodeType
	 */
	public String getServiceCodeType() {
		return serviceCodeType;
	}

	/**
	 * @param serviceCodeType the serviceCodeType to set
	 */
	public void setServiceCodeType(String serviceCodeType) {
		this.serviceCodeType = serviceCodeType;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	
}
