package com.dc.evans.edi.model.x12.edi204.v5010;

import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;

import com.dc.evans.edi.model.x12.segment.EquipmentDetail;
import com.dc.evans.edi.model.x12.segment.Measurement;

@EDISegmentGroup
public class EquipmentGroup {

	@NotNull
	private EquipmentDetail equipmentDetail;
	
	private Measurement measurement;

	/**
	 * @return the equipmentDetail
	 */
	public EquipmentDetail getEquipmentDetail() {
		return equipmentDetail;
	}

	/**
	 * @param equipmentDetail the equipmentDetail to set
	 */
	public void setEquipmentDetail(EquipmentDetail equipmentDetail) {
		this.equipmentDetail = equipmentDetail;
	}

	/**
	 * @return the measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}
}
