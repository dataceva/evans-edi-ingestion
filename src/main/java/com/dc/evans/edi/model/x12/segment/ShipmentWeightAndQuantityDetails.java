package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="AT8")
public class ShipmentWeightAndQuantityDetails {

	@NotNull
	@Size(min=3, max=3)
	@EDIElement(fieldName="AT801", dataElement="187")
	private String weightQualifier;

	@NotNull
	@EDIElement(fieldName="AT802", dataElement="355")
	@Size(min=2, max=2)
	private String unitOrBasisForWeight; 
	
	@NotNull
	@EDIElement(fieldName="AT803", dataElement="81")
	private BigDecimal weight;
	
	@NotNull
	@EDIElement(fieldName="AT804", dataElement="80")
	private BigInteger ladingQuantity;
	
	@NotNull
	@EDIElement(fieldName="AT806", dataElement="81")
	private BigDecimal volume;
	
	@NotNull
	@EDIElement(fieldName="AT807", dataElement="355")
	@Size(min=2, max=2)
	private String unitOrBasisForVolume;

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
	 * @return the unitOrBasisForWeight
	 */
	public String getUnitOrBasisForWeight() {
		return unitOrBasisForWeight;
	}

	/**
	 * @param unitOrBasisForWeight the unitOrBasisForWeight to set
	 */
	public void setUnitOrBasisForWeight(String unitOrBasisForWeight) {
		this.unitOrBasisForWeight = unitOrBasisForWeight;
	}

	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * @return the ladingQuantity
	 */
	public BigInteger getLadingQuantity() {
		return ladingQuantity;
	}

	/**
	 * @param ladingQuantity the ladingQuantity to set
	 */
	public void setLadingQuantity(BigInteger ladingQuantity) {
		this.ladingQuantity = ladingQuantity;
	}

	/**
	 * @return the volume
	 */
	public BigDecimal getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	/**
	 * @return the unitOrBasisForVolume
	 */
	public String getUnitOrBasisForVolume() {
		return unitOrBasisForVolume;
	}

	/**
	 * @param unitOrBasisForVolume the unitOrBasisForVolume to set
	 */
	public void setUnitOrBasisForVolume(String unitOrBasisForVolume) {
		this.unitOrBasisForVolume = unitOrBasisForVolume;
	}

}
