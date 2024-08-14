package com.dc.evans.edi.model.x12.segment;

import javax.edi.bind.annotations.EDIElement;
import javax.edi.bind.annotations.EDISegment;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EDISegment(tag="AK9")
public class FunctionalGroupResponseTrailer {
	
	@EDIElement(fieldName="AK901", dataElement="715")
	@NotNull
	@Size(min=1, max=1)
	private String functionalGroupAcknowledgeCode;
	
	@EDIElement(fieldName="AK902", dataElement="97")
	@NotNull
	@Size(min=1, max=6)
	private Integer numberOfTransactionSetsIncluded;
	
	@EDIElement(fieldName="AK903", dataElement="123")
	@NotNull
	@Size(min=1, max=6)
	private Integer numberOfReceivedTransactionSets;
	
	@EDIElement(fieldName="AK904", dataElement="2")
	@NotNull
	@Size(min=1, max=6)
	private Integer numberOfAcceptedTransactionSets;
	
	@EDIElement(fieldName="AK905", dataElement="716")
	@Size(min=1, max=3)
	private String functionalGroupSyntaxErrorCode1;
	
	@EDIElement(fieldName="AK906", dataElement="716")
	@Size(min=1, max=3)
	private String functionalGroupSyntaxErrorCode2;
	
	@EDIElement(fieldName="AK907", dataElement="716")
	@Size(min=1, max=3)
	private String functionalGroupSyntaxErrorCode3;
	
	@EDIElement(fieldName="AK908", dataElement="716")
	@Size(min=1, max=3)
	private String functionalGroupSyntaxErrorCode4;
	
	@EDIElement(fieldName="AK909", dataElement="716")
	@Size(min=1, max=3)
	private String functionalGroupSyntaxErrorCode5;

	/**
	 * @return the functionalGroupAcknowledgeCode
	 */
	public String getFunctionalGroupAcknowledgeCode() {
		return functionalGroupAcknowledgeCode;
	}

	/**
	 * @param functionalGroupAcknowledgeCode the functionalGroupAcknowledgeCode to set
	 */
	public void setFunctionalGroupAcknowledgeCode(String functionalGroupAcknowledgeCode) {
		this.functionalGroupAcknowledgeCode = functionalGroupAcknowledgeCode;
	}

	/**
	 * @return the numberOfTransactionSetsIncluded
	 */
	public Integer getNumberOfTransactionSetsIncluded() {
		return numberOfTransactionSetsIncluded;
	}

	/**
	 * @param numberOfTransactionSetsIncluded the numberOfTransactionSetsIncluded to set
	 */
	public void setNumberOfTransactionSetsIncluded(Integer numberOfTransactionSetsIncluded) {
		this.numberOfTransactionSetsIncluded = numberOfTransactionSetsIncluded;
	}

	/**
	 * @return the numberOfReceivedTransactionSets
	 */
	public Integer getNumberOfReceivedTransactionSets() {
		return numberOfReceivedTransactionSets;
	}

	/**
	 * @param numberOfReceivedTransactionSets the numberOfReceivedTransactionSets to set
	 */
	public void setNumberOfReceivedTransactionSets(Integer numberOfReceivedTransactionSets) {
		this.numberOfReceivedTransactionSets = numberOfReceivedTransactionSets;
	}

	/**
	 * @return the numberOfAcceptedTransactionSets
	 */
	public Integer getNumberOfAcceptedTransactionSets() {
		return numberOfAcceptedTransactionSets;
	}

	/**
	 * @param numberOfAcceptedTransactionSets the numberOfAcceptedTransactionSets to set
	 */
	public void setNumberOfAcceptedTransactionSets(Integer numberOfAcceptedTransactionSets) {
		this.numberOfAcceptedTransactionSets = numberOfAcceptedTransactionSets;
	}

	/**
	 * @return the functionalGroupSyntaxErrorCode1
	 */
	public String getFunctionalGroupSyntaxErrorCode1() {
		return functionalGroupSyntaxErrorCode1;
	}

	/**
	 * @param functionalGroupSyntaxErrorCode1 the functionalGroupSyntaxErrorCode1 to set
	 */
	public void setFunctionalGroupSyntaxErrorCode1(String functionalGroupSyntaxErrorCode1) {
		this.functionalGroupSyntaxErrorCode1 = functionalGroupSyntaxErrorCode1;
	}

	/**
	 * @return the functionalGroupSyntaxErrorCode2
	 */
	public String getFunctionalGroupSyntaxErrorCode2() {
		return functionalGroupSyntaxErrorCode2;
	}

	/**
	 * @param functionalGroupSyntaxErrorCode2 the functionalGroupSyntaxErrorCode2 to set
	 */
	public void setFunctionalGroupSyntaxErrorCode2(String functionalGroupSyntaxErrorCode2) {
		this.functionalGroupSyntaxErrorCode2 = functionalGroupSyntaxErrorCode2;
	}

	/**
	 * @return the functionalGroupSyntaxErrorCode3
	 */
	public String getFunctionalGroupSyntaxErrorCode3() {
		return functionalGroupSyntaxErrorCode3;
	}

	/**
	 * @param functionalGroupSyntaxErrorCode3 the functionalGroupSyntaxErrorCode3 to set
	 */
	public void setFunctionalGroupSyntaxErrorCode3(String functionalGroupSyntaxErrorCode3) {
		this.functionalGroupSyntaxErrorCode3 = functionalGroupSyntaxErrorCode3;
	}

	/**
	 * @return the functionalGroupSyntaxErrorCode4
	 */
	public String getFunctionalGroupSyntaxErrorCode4() {
		return functionalGroupSyntaxErrorCode4;
	}

	/**
	 * @param functionalGroupSyntaxErrorCode4 the functionalGroupSyntaxErrorCode4 to set
	 */
	public void setFunctionalGroupSyntaxErrorCode4(String functionalGroupSyntaxErrorCode4) {
		this.functionalGroupSyntaxErrorCode4 = functionalGroupSyntaxErrorCode4;
	}

	/**
	 * @return the functionalGroupSyntaxErrorCode5
	 */
	public String getFunctionalGroupSyntaxErrorCode5() {
		return functionalGroupSyntaxErrorCode5;
	}

	/**
	 * @param functionalGroupSyntaxErrorCode5 the functionalGroupSyntaxErrorCode5 to set
	 */
	public void setFunctionalGroupSyntaxErrorCode5(String functionalGroupSyntaxErrorCode5) {
		this.functionalGroupSyntaxErrorCode5 = functionalGroupSyntaxErrorCode5;
	}
}
