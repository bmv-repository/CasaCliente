/**
 * Bursatec - BMV 07/12/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.sample.https.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bursatec.sample.https.service.MockProcessMessagesService;
import com.bursatec.sample.https.vo.PayloadRequestMessageDVO;
import com.bursatec.sample.https.vo.PayloadRequestMessageFinalizeVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageDVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageFinalizeVO;

/**
 * Clase que expone Ws Rest
 * 
 * @author jbucio-badak - Bursatec
 * @version 1.0
 */
@RestController
@RequestMapping("/CasaClienteService/transmision")
public class RestServicesContoller {
    /**
     * Objecto para simulara la logica de negocio.
     */
    @Autowired
    MockProcessMessagesService mockProcessMessagesServiceImpl;

    /**
     * Metodo para la recepcion de mensajes tipo D.
     * 
     * @param payload Request.
     * @return
     */
    @RequestMapping(value = "/messages", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayloadResponseMessageDVO> receiverMessageD(
            @RequestBody PayloadRequestMessageDVO payload) {

        return new ResponseEntity<PayloadResponseMessageDVO>(
                mockProcessMessagesServiceImpl.messagesDprocessed(payload),
                HttpStatus.OK);

    }

    /**
     * Metodo para la recepcion de mensajes Finaliza
     * 
     * @param payload Request.
     * @return
     * @throws FileNotFoundException
     * @throws InterruptedException
     * @throws IOException
     */
    @RequestMapping(value = "/finalize", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayloadResponseMessageFinalizeVO> receiverMessageFinalize(
            @RequestBody PayloadRequestMessageFinalizeVO payload)
            throws FileNotFoundException, InterruptedException, IOException {

        return new ResponseEntity<PayloadResponseMessageFinalizeVO>(
                mockProcessMessagesServiceImpl
                        .messagesFinalizeProcessed(payload),
                HttpStatus.OK);
    }

}
