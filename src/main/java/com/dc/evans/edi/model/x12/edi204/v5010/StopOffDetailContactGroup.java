package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.ArrayList;
import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.AddressInformation;
import com.dc.evans.edi.model.x12.segment.GeographicLocation;
import com.dc.evans.edi.model.x12.segment.Name;
import com.dc.evans.edi.model.x12.segment.PersonContact;

@EDISegmentGroup
public class StopOffDetailContactGroup {
	
	@NotNull
	private Name name;
	
	private AddressInformation addressInformation;
	
	private GeographicLocation geographicLocation;
	
	@NotNull
	@Size(max=100000)
	@EDICollectionType(PersonContact.class)
	private Collection<PersonContact> personContact = new ArrayList<PersonContact>();

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

	/**
	 * @return the personContact
	 */
	public Collection<PersonContact> getPersonContact() {
		return personContact;
	}

	/**
	 * @param personContact the personContact to set
	 */
	public void setPersonContact(Collection<PersonContact> personContact) {
		this.personContact = personContact;
	}
}
