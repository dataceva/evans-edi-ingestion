package com.dc.evans.edi.model.x12.edi204.v4010;

import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;

import com.dc.evans.edi.model.x12.segment.AddressInformation;
import com.dc.evans.edi.model.x12.segment.GeographicLocation;
import com.dc.evans.edi.model.x12.segment.Name;
import com.dc.evans.edi.model.x12.segment.PersonContact;

@EDISegmentGroup
public class ShippingBillingGroup {

	@NotNull
	private Name name;
	
	private AddressInformation addressInformation;
	
	private GeographicLocation geographicLocation;
	
	private PersonContact contact;

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return the contact
	 */
	public PersonContact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(PersonContact contact) {
		this.contact = contact;
	}

	/**
	 * @return the addressInformation
	 */
	public AddressInformation getAddressInformation() {
		return addressInformation;
	}

	/**
	 * @param addressInformation the addressInformation to set
	 */
	public void setAddressInformation(AddressInformation addressInformation) {
		this.addressInformation = addressInformation;
	}

	/**
	 * @return the geographicLocation
	 */
	public GeographicLocation getGeographicLocation() {
		return geographicLocation;
	}

	/**
	 * @param geographicLocation the geographicLocation to set
	 */
	public void setGeographicLocation(GeographicLocation geographicLocation) {
		this.geographicLocation = geographicLocation;
	}
	
}
