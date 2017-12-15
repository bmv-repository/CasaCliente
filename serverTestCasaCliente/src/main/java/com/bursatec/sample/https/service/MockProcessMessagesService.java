/**
 * Bursatec - BMV 07/12/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.sample.https.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bursatec.sample.https.vo.PayloadRequestMessageDVO;
import com.bursatec.sample.https.vo.PayloadRequestMessageFinalizeVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageDVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageFinalizeVO;

/**
 * Interface de utileria para simular logica de negocio.
    * @author jbucio-badak - Bursatec
    * @version 1.0
 */
public interface MockProcessMessagesService {
    
    /**
     *  Metodo mock para el procesamiento de mensajes tipo D.
        * @param payload
        * @return
     */
    public PayloadResponseMessageDVO messagesDprocessed(PayloadRequestMessageDVO payload);
    
    /**
     *  Metodo mock para el procesamiento de mensajes tipo Finaliza.
     */
    public PayloadResponseMessageFinalizeVO messagesFinalizeProcessed(
            PayloadRequestMessageFinalizeVO payload)
            throws FileNotFoundException, InterruptedException, IOException;

}
