/**
 * 
 */
package com.dc.evans.edi.model.x12.edi;

import java.util.Collection;

import javax.edi.bind.annotations.EDIMessage;

import com.dc.evans.edi.model.x12.segment.GroupEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.GroupEnvelopeTrailer;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeTrailer;

/**
 * @author jainj
 *
 */
@EDIMessage(componentDelimiter='>',elementDelimiter='*',segmentDelimiter='~')
public interface IEDIMessage<T,B> {
	InterchangeEnvelopeHeader getEnvelopeHeader();

	GroupEnvelopeHeader getGroupEnvelopeHeader();
	
	Collection<IEDIMessageBody<B>> getBody();
	
	GroupEnvelopeTrailer getGroupEnvelopeTrailer();

	InterchangeEnvelopeTrailer getEnvelopeTrailer();
}
