/**
 * 
 */
package com.dc.evans.edi.model.x12.edi;

import com.dc.evans.edi.model.x12.segment.TransactionSetHeader;

/**
 * @author jainj
 *
 */
public interface IEDIMessageBodyHeader<T> {
	TransactionSetHeader getTransactionSetHeader();
}
