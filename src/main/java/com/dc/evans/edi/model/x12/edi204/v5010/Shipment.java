package com.dc.evans.edi.model.x12.edi204.v5010;

import java.util.List;

import javax.edi.bind.annotations.EDICollectionType;
import javax.edi.bind.annotations.EDIMessage;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dc.evans.edi.model.x12.edi.IEDIMessage;
import com.dc.evans.edi.model.x12.edi.IEDIMessageBody;
import com.dc.evans.edi.model.x12.segment.GroupEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.GroupEnvelopeTrailer;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeTrailer;

@EDIMessage
public class Shipment implements IEDIMessage<Shipment,ShipmentBody> {
	
	@NotNull
	private InterchangeEnvelopeHeader envelopeHeader;
	
	@NotNull
	private GroupEnvelopeHeader groupEnvelopeHeader;
	
	@NotNull
	@Size(min=1)
	@EDICollectionType(ShipmentBody.class)
	private List<IEDIMessageBody<ShipmentBody>> body;
	
	@NotNull
	private GroupEnvelopeTrailer groupEnvelopeTrailer;
	@NotNull
	private InterchangeEnvelopeTrailer envelopeTrailer;
	
	public InterchangeEnvelopeHeader getEnvelopeHeader() {
		return envelopeHeader;
	}
	public void setEnvelopeHeader(InterchangeEnvelopeHeader envelopeHeader) {
		this.envelopeHeader = envelopeHeader;
	}
	public GroupEnvelopeHeader getGroupEnvelopeHeader() {
		return groupEnvelopeHeader;
	}
	public void setGroupEnvelopeHeader(GroupEnvelopeHeader groupEnvelopeHeader) {
		this.groupEnvelopeHeader = groupEnvelopeHeader;
	}
	public List<IEDIMessageBody<ShipmentBody>> getBody() {
		return body;
	}
	public void setBody(List<IEDIMessageBody<ShipmentBody>> body) {
		this.body = body;
	}
	public GroupEnvelopeTrailer getGroupEnvelopeTrailer() {
		return groupEnvelopeTrailer;
	}
	public void setGroupEnvelopeTrailer(GroupEnvelopeTrailer groupEnvelopeTrailer) {
		this.groupEnvelopeTrailer = groupEnvelopeTrailer;
	}
	public InterchangeEnvelopeTrailer getEnvelopeTrailer() {
		return envelopeTrailer;
	}
	public void setEnvelopeTrailer(InterchangeEnvelopeTrailer envelopeTrailer) {
		this.envelopeTrailer = envelopeTrailer;
	}
	@Override
	public String toString() {
		return "Invoice [envelopeHeader=" + envelopeHeader
				+ ", groupEnvelopeHeader=" + groupEnvelopeHeader + ", body="
				+ body + ", groupEnvelopeTrailer=" + groupEnvelopeTrailer
				+ ", envelopeTrailer=" + envelopeTrailer + "]";
	}
	
}
