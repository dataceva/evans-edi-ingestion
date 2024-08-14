package com.dc.evans.edi.model.x12.edi204.v4010;

import java.util.Collection;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.segment.AddressInformation;
import com.dc.evans.edi.model.x12.segment.GeographicLocation;
import com.dc.evans.edi.model.x12.segment.Name;

@EDISegmentGroup
public class PartyIdentificationGroup {

	@NotNull
	private Name name;
	
	@NotNull
	@Size(max=100000)
	@EDICollectionType(AddressInformation.class)
	private Collection<AddressInformation> addressInformation;
	
	@NotNull
	private GeographicLocation geographicLocation;

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
	public Collection<AddressInformation> getAddressInformation() {
		return addressInformation;
	}

	/**
	 * @param addressInformation the addressInformation to set
	 */
	public void setAddressInformation(Collection<AddressInformation> addressInformation) {
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
