//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.08.20 at 03:28:09 PM IST 
//


package com.dc.evans.schema.mercurygate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="HazMatID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProperShippingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HazMatClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HazMatPlacards" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HazMatPlacardsDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:MercuryGate:import}HazMatFlashPointTemp" minOccurs="0"/&gt;
 *         &lt;element name="HazMatEMSNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "HazMatDetail")
public class HazMatDetail {

    @XmlElement(name = "HazMatID")
    protected String hazMatID;
    @XmlElement(name = "ProperShippingName")
    protected String properShippingName;
    @XmlElement(name = "PackageGroup")
    protected String packageGroup;
    @XmlElement(name = "HazMatClass")
    protected String hazMatClass;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "ContactPhone")
    protected String contactPhone;
    @XmlElement(name = "HazMatPlacards")
    protected String hazMatPlacards;
    @XmlElement(name = "HazMatPlacardsDetails")
    protected String hazMatPlacardsDetails;
    @XmlElement(name = "HazMatFlashPointTemp")
    protected HazMatFlashPointTemp hazMatFlashPointTemp;
    @XmlElement(name = "HazMatEMSNumber")
    protected String hazMatEMSNumber;
    @XmlElement(name = "Comments")
    protected String comments;

    /**
     * Gets the value of the hazMatID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazMatID() {
        return hazMatID;
    }

    /**
     * Sets the value of the hazMatID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazMatID(String value) {
        this.hazMatID = value;
    }

    /**
     * Gets the value of the properShippingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperShippingName() {
        return properShippingName;
    }

    /**
     * Sets the value of the properShippingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperShippingName(String value) {
        this.properShippingName = value;
    }

    /**
     * Gets the value of the packageGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageGroup() {
        return packageGroup;
    }

    /**
     * Sets the value of the packageGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageGroup(String value) {
        this.packageGroup = value;
    }

    /**
     * Gets the value of the hazMatClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazMatClass() {
        return hazMatClass;
    }

    /**
     * Sets the value of the hazMatClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazMatClass(String value) {
        this.hazMatClass = value;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the hazMatPlacards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazMatPlacards() {
        return hazMatPlacards;
    }

    /**
     * Sets the value of the hazMatPlacards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazMatPlacards(String value) {
        this.hazMatPlacards = value;
    }

    /**
     * Gets the value of the hazMatPlacardsDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazMatPlacardsDetails() {
        return hazMatPlacardsDetails;
    }

    /**
     * Sets the value of the hazMatPlacardsDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazMatPlacardsDetails(String value) {
        this.hazMatPlacardsDetails = value;
    }

    /**
     * Gets the value of the hazMatFlashPointTemp property.
     * 
     * @return
     *     possible object is
     *     {@link HazMatFlashPointTemp }
     *     
     */
    public HazMatFlashPointTemp getHazMatFlashPointTemp() {
        return hazMatFlashPointTemp;
    }

    /**
     * Sets the value of the hazMatFlashPointTemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazMatFlashPointTemp }
     *     
     */
    public void setHazMatFlashPointTemp(HazMatFlashPointTemp value) {
        this.hazMatFlashPointTemp = value;
    }

    /**
     * Gets the value of the hazMatEMSNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazMatEMSNumber() {
        return hazMatEMSNumber;
    }

    /**
     * Sets the value of the hazMatEMSNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazMatEMSNumber(String value) {
        this.hazMatEMSNumber = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

}
