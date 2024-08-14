/**
 * 
 */
package com.dc.evans.edi.model.x12.edi;

import com.dc.evans.edi.model.x12.segment.TransactionSetTotals;
import com.dc.evans.edi.model.x12.segment.TransactionSetTrailer;

/**
 * @author jainj
 *
 */
public interface IEDIMessageBodyTrailer<T> {
	
	TransactionSetTrailer getTransactionSetTrailer();
}
