/**
 * Bursatec - BMV 14/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.vo;

import java.util.List;

/**
 * 
 * @author jbucio-badak
 *
 */
public class PayloadResponseMessageFinalizeVO {
	/**
	 * lista de mensajes
	 */
	private List<MessageCommonVO> listMessages;

	/**
	 * constructor sin argumentos
	 */
	public PayloadResponseMessageFinalizeVO() {
	}

	/**
	 * Constructor con Argumentos
	 * 
	 * @param listMessages
	 */
	public PayloadResponseMessageFinalizeVO(final List<MessageCommonVO> listMessages) {
		super();
		this.listMessages = listMessages;
	}

	/**
	 * 
	 * @return listMessages
	 */
	public List<MessageCommonVO> getListMessages() {
		return listMessages;
	}

	/**
	 * 
	 * @param listMessages
	 */
	public void setListMessages(final List<MessageCommonVO> listMessages) {
		this.listMessages = listMessages;
	}

	@Override
	public String toString() {
		return "PayloadResponseMessageFinalizeVO [listMessages=" + listMessages + "]";
	}

}
