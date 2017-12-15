/**
 * Bursatec - BMV 07/12/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.sample.https.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.bursatec.sample.https.vo.MessageCommonVO;
import com.bursatec.sample.https.vo.PayloadRequestMessageDVO;
import com.bursatec.sample.https.vo.PayloadRequestMessageFinalizeVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageDVO;
import com.bursatec.sample.https.vo.PayloadResponseMessageFinalizeVO;

/**
 * Clase de utileria para la simulacion de la logica de negocio en la recepcion
 * de mensajes de CC.
 * 
 * @author jbucio-badak - Bursatec
 * @version 1.0
 */
@Service
public class MockProcessMessagesServiceImpl
        implements MockProcessMessagesService {
    /**
     * Utileria para cargar archivoss.
     */
    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * Estructura de un mensaje D.
     */
    private static final String STRUCTURE_MESSAGE_D = "D ";

    /**
     * Metodo mock para el procesamiento de mensajes tipo D.
     */
    @Override
    public PayloadResponseMessageDVO messagesDprocessed(
            final PayloadRequestMessageDVO payload) {

        long processedMessages = 0;
        long structuredBadMessages = 0;

        for (MessageCommonVO message : payload.getListMessages()) {
            if (isMessageD(message.getMessage())) {
                processedMessages++;
            } else {
                structuredBadMessages++;
            }
        }

        return new PayloadResponseMessageDVO("success",
                payload.getListMessages().size(), processedMessages,
                structuredBadMessages);

    }

    /**
     * Metodo Mock para el procesamiento de mensajes tipo Finaliza.
     */
    @Override
    public PayloadResponseMessageFinalizeVO messagesFinalizeProcessed(
            final PayloadRequestMessageFinalizeVO payload)
            throws FileNotFoundException, InterruptedException, IOException {

        return new PayloadResponseMessageFinalizeVO(getFinalizeMessageByCC());

    }

    /**
     * Metodo Mock para validacion de mensajes tipo D.
     * 
     * @param m
     * @return
     */
    private boolean isMessageD(final String m) {

        String messageSub = m.substring(3, 5);

        return messageSub.equalsIgnoreCase(STRUCTURE_MESSAGE_D);
    }

    /**
     * Metodo Mock para la generacion de una respuesta para un mensaje finaliza.
     * 
     * @return
     * @throws InterruptedException
     * @throws FileNotFoundException
     * @throws IOException
     */
    private List<MessageCommonVO> getFinalizeMessageByCC()
            throws InterruptedException, FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(resourceLoader.getResource("classpath:FINAL.txt").getInputStream()));

        String linea;
        List<MessageCommonVO> list = new ArrayList<>();
        MessageCommonVO message;
        while ((linea = br.readLine()) != null) {
            System.out.println("Linea: " + linea);
            message = new MessageCommonVO();
            message.setMessage(linea);
            list.add(message);
        }

        return list;

    }

}
