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
 *       &lt;sequence&gt;
 *         &lt;element name="Method" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{urn:MercuryGate:import}BillTo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "method",
    "billTo"
})
@XmlRootElement(name = "Payment")
public class Payment {

    @XmlElement(name = "Method", required = true)
    protected String method;
    @XmlElement(name = "BillTo")
    protected TypeLocationEnvelope billTo;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the billTo property.
     * 
     * @return
     *     possible object is
     *     {@link TypeLocationEnvelope }
     *     
     */
    public TypeLocationEnvelope getBillTo() {
        return billTo;
    }

    /**
     * Sets the value of the billTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeLocationEnvelope }
     *     
     */
    public void setBillTo(TypeLocationEnvelope value) {
        this.billTo = value;
    }

}
