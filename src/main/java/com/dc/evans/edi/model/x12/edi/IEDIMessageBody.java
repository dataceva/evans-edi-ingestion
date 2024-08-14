/**
 * 
 */
package com.dc.evans.edi.model.x12.edi;/**
 * @author jainj
 *
 */
public interface IEDIMessageBody<B> {
	IEDIMessageBodyHeader<?> getHeader();
	
	IEDIMessageBodyDetail<?> getDetail();
	
	IEDIMessageBodyTrailer<?> getTrailer();
}
