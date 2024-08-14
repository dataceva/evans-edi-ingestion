package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="TD3")
public class CarrierDetail {

	@EDIElement(fieldName="TD301", dataElement="40")
	@Size(min=2,max=2)
	private String equipmentCode;
	
	@EDIElement(fieldName="TD302", dataElement="206")
	@Size(min=1,max=4)
	private String equipmentName;
	
	@EDIElement(fieldName="TD303", dataElement="207")
	@Size(min=1,max=10)
	private String equipmentNumber;
	
	@EDIElement(fieldName="TD309", dataElement="225")
	@Size(min=2,max=15)
	private String sealNumber;

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
	 * @return the equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * @param equipmentName the equipmentName to set
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

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
	 * @return the sealNumber
	 */
	public String getSealNumber() {
		return sealNumber;
	}

	/**
	 * @param sealNumber the sealNumber to set
	 */
	public void setSealNumber(String sealNumber) {
		this.sealNumber = sealNumber;
	}
	
}
