package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.Size;

@EDISegment(tag="PAL")
public class PalletInformation {

	@Size(min=1, max=2)
	@EDIElement(fieldName="PAL01", dataElement="883")
	private String palletCode;
	
	@Size(min=1, max=3)
	@EDIElement(fieldName="PAL02", dataElement="884")
	private String palletType;
	
	@Size(min=1, max=3)
	@EDIElement(fieldName="PAL03", dataElement="885")
	private String palletBlock;
	
	@Size(min=1, max=6)
	@EDIElement(fieldName="PAL04", dataElement="356")
	private Integer pack;
	
	@Size(min=1, max=6)
	@EDIElement(fieldName="PAL05", dataElement="396")
	private Double unitWeight;
	
	@Size(min=1, max=2)
	@EDIElement(fieldName="PAL06", dataElement="355")
	private String unitWeightUOM;
	
	@Size(min=1, max=8)
	@EDIElement(fieldName="PAL07", dataElement="82")
	private Integer length;
	
	@Size(min=1, max=8)
	@EDIElement(fieldName="PAL08", dataElement="189")
	private Integer width;
	
	@Size(min=1, max=8)
	@EDIElement(fieldName="PAL09", dataElement="65")
	private Integer height;
	
	@Size(min=2, max=2)
	@EDIElement(fieldName="PAL10", dataElement="355")
	private String uom;
	
	@Size(min=1, max=9)
	@EDIElement(fieldName="PAL11", dataElement="384")
	private Double grossWeightPerCarton;
	
	@Size(min=2, max=2)
	@EDIElement(fieldName="PAL12", dataElement="355")
	private String grossWeightPerCartonUom;
	
	@Size(min=1, max=9)
	@EDIElement(fieldName="PAL13", dataElement="384")
	private String cartonCubes;

	/**
	 * @return the palletCode
	 */
	public String getPalletCode() {
		return palletCode;
	}

	/**
	 * @param palletCode the palletCode to set
	 */
	public void setPalletCode(String palletCode) {
		this.palletCode = palletCode;
	}

	/**
	 * @return the palletType
	 */
	public String getPalletType() {
		return palletType;
	}

	/**
	 * @param palletType the palletType to set
	 */
	public void setPalletType(String palletType) {
		this.palletType = palletType;
	}

	/**
	 * @return the palletBlock
	 */
	public String getPalletBlock() {
		return palletBlock;
	}

	/**
	 * @param palletBlock the palletBlock to set
	 */
	public void setPalletBlock(String palletBlock) {
		this.palletBlock = palletBlock;
	}

	/**
	 * @return the pack
	 */
	public Integer getPack() {
		return pack;
	}

	/**
	 * @param pack the pack to set
	 */
	public void setPack(Integer pack) {
		this.pack = pack;
	}

	/**
	 * @return the unitWeight
	 */
	public Double getUnitWeight() {
		return unitWeight;
	}

	/**
	 * @param unitWeight the unitWeight to set
	 */
	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	/**
	 * @return the unitWeightUOM
	 */
	public String getUnitWeightUOM() {
		return unitWeightUOM;
	}

	/**
	 * @param unitWeightUOM the unitWeightUOM to set
	 */
	public void setUnitWeightUOM(String unitWeightUOM) {
		this.unitWeightUOM = unitWeightUOM;
	}

	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
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
	 * @return the grossWeightPerCarton
	 */
	public Double getGrossWeightPerCarton() {
		return grossWeightPerCarton;
	}

	/**
	 * @param grossWeightPerCarton the grossWeightPerCarton to set
	 */
	public void setGrossWeightPerCarton(Double grossWeightPerCarton) {
		this.grossWeightPerCarton = grossWeightPerCarton;
	}

	/**
	 * @return the grossWeightPerCartonUom
	 */
	public String getGrossWeightPerCartonUom() {
		return grossWeightPerCartonUom;
	}

	/**
	 * @param grossWeightPerCartonUom the grossWeightPerCartonUom to set
	 */
	public void setGrossWeightPerCartonUom(String grossWeightPerCartonUom) {
		this.grossWeightPerCartonUom = grossWeightPerCartonUom;
	}

	/**
	 * @return the cartonCubes
	 */
	public String getCartonCubes() {
		return cartonCubes;
	}

	/**
	 * @param cartonCubes the cartonCubes to set
	 */
	public void setCartonCubes(String cartonCubes) {
		this.cartonCubes = cartonCubes;
	}

}
