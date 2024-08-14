package com.dc.evans.edi.model.x12.segment;

import java.math.BigDecimal;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.edi.bind.annotations.elements.EDIElementFormat;
import javax.validation.constraints.NotNull;


@EDISegment(tag="L3")
public class TotalWeightAndChargeSummary {

	@EDIElement(fieldName="L301", dataElement="81")
	@NotNull
	@EDIElementFormat("####.##")
	private BigDecimal weight;
	
	@EDIElement(fieldName="L302", dataElement="187")
	@NotNull
	private String weightQualifier;
	
	@EDIElement(fieldName="L303", dataElement="81")
	@NotNull
	@EDIElementFormat("####.##")
	private BigDecimal freight;
	
	@EDIElement(fieldName="L304", dataElement="187")
	@NotNull
	private String freightQualifier;
	
	@EDIElement(fieldName="L305", dataElement="187")
	@NotNull
	private Long charge;
	
	@EDIElement(fieldName="L306", dataElement="187")
	@NotNull
	private Long advances;
	
	@EDIElement(fieldName="L307", dataElement="187")
	@NotNull
	private Long prepaidAmount;
	
	@EDIElement(fieldName="L308", dataElement="187")
	@NotNull
	private Long specialChargeCode;
	
	@EDIElement(fieldName="L303", dataElement="81")
	@NotNull
	@EDIElementFormat("####.##")
	private BigDecimal volume;
	
	@EDIElement(fieldName="L304", dataElement="187")
	@NotNull
	private String volumeQualifier;
	
	@EDIElement(fieldName="L311", dataElement="80")
	private Integer ladingQuantity;
	
	@EDIElement(fieldName="L312", dataElement="391")
	private String weightUOM;

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
	 * @return the freight
	 */
	public BigDecimal getFreight() {
		return freight;
	}

	/**
	 * @param freight the freight to set
	 */
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	/**
	 * @return the freightQualifier
	 */
	public String getFreightQualifier() {
		return freightQualifier;
	}

	/**
	 * @param freightQualifier the freightQualifier to set
	 */
	public void setFreightQualifier(String freightQualifier) {
		this.freightQualifier = freightQualifier;
	}

	/**
	 * @return the charge
	 */
	public Long getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(Long charge) {
		this.charge = charge;
	}

	/**
	 * @return the advances
	 */
	public Long getAdvances() {
		return advances;
	}

	/**
	 * @param advances the advances to set
	 */
	public void setAdvances(Long advances) {
		this.advances = advances;
	}

	/**
	 * @return the prepaidAmount
	 */
	public Long getPrepaidAmount() {
		return prepaidAmount;
	}

	/**
	 * @param prepaidAmount the prepaidAmount to set
	 */
	public void setPrepaidAmount(Long prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}

	/**
	 * @return the specialChargeCode
	 */
	public Long getSpecialChargeCode() {
		return specialChargeCode;
	}

	/**
	 * @param specialChargeCode the specialChargeCode to set
	 */
	public void setSpecialChargeCode(Long specialChargeCode) {
		this.specialChargeCode = specialChargeCode;
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
	 * @return the volumeQualifier
	 */
	public String getVolumeQualifier() {
		return volumeQualifier;
	}

	/**
	 * @param volumeQualifier the volumeQualifier to set
	 */
	public void setVolumeQualifier(String volumeQualifier) {
		this.volumeQualifier = volumeQualifier;
	}

	/**
	 * @return the ladingQuantity
	 */
	public Integer getLadingQuantity() {
		return ladingQuantity;
	}

	/**
	 * @param ladingQuantity the ladingQuantity to set
	 */
	public void setLadingQuantity(Integer ladingQuantity) {
		this.ladingQuantity = ladingQuantity;
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
}
