/**
 * 
 */
package com.dc.evans.util;

/**
 * @author jainj
 *
 */
public class EDIFileIdentifier {

	private String fileType;
	private int ediVersion;
	private String customerISAId;
	
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerISAId() {
		return customerISAId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerISAId(String customerISAId) {
		this.customerISAId = customerISAId;
	}
	/**
	 * @return the ediVersion
	 */
	public int getEdiVersion() {
		return ediVersion;
	}
	/**
	 * @param ediVersion the ediVersion to set
	 */
	public void setEdiVersion(int ediVersion) {
		this.ediVersion = ediVersion;
	}
}
