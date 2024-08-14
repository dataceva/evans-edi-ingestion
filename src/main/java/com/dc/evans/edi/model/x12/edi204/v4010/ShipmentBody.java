package com.dc.evans.edi.model.x12.edi204.v4010;

import javax.edi.bind.annotations.EDISegmentGroup;
import javax.validation.constraints.NotNull;

import com.dc.evans.edi.model.x12.edi.IEDIMessageBody;

@EDISegmentGroup
public class ShipmentBody implements IEDIMessageBody<ShipmentBody> {

	@NotNull
	private Header header;
	
	@NotNull
	private Detail detail;
	
	@NotNull
	private Trailer trailer;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "InvoiceBody [header=" + header + ", detail=" + detail
				+ ", trailer=" + trailer + "]";
	}
	
	
}
