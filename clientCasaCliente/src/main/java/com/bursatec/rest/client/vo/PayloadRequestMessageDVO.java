/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.vo;

import java.util.List;

/**
 * @author jbucio-badak
 */
public class PayloadRequestMessageDVO {

    /**
     * Lista de mensajes.
     */
    private List<MessageCommonVO> listMessages;

    /**
     * @return listMessages.
     */
    public List<MessageCommonVO> getListMessages() {
        return listMessages;
    }

    /**
     * @param listMessages 
     */
    public void setListMessages(final List<MessageCommonVO> listMessages) {
        this.listMessages = listMessages;
    }

}
