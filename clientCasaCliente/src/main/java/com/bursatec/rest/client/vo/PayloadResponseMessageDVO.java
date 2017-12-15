/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase para el serializado de la respuesta.
 * 
 * @author jbucio-badak
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PayloadResponseMessageDVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * regresa un mensjae informativo.
	 */
	private String message;

	/**
	 * Numero de mensajes recibidos.
	 */
	private long receivedMessages;
	/**
	 * Numero de Mensaje procesados.
	 */
	private long processedMessages;
	/**
	 * Numero de mensajes mal estructurados.
	 */
	private long structuredBadMessages;
	
	/**
	 * Constructo sin Argumentos
	 */
	public PayloadResponseMessageDVO() {
		
	}

	/**
	 * Constructor con argumentos.
	 * @param message
	 * @param receivedMessages
	 * @param processedMessages
	 * @param structuredBadMessages
	 */
	public PayloadResponseMessageDVO(final String message, final long receivedMessages, final long processedMessages,
			final long structuredBadMessages) {
		super();
		this.message = message;
		this.receivedMessages = receivedMessages;
		this.processedMessages = processedMessages;
		this.structuredBadMessages = structuredBadMessages;
	}

	/**
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return receivedMessages
	 */
	public long getReceivedMessages() {
		return receivedMessages;
	}

	/**
	 * 
	 * @param receivedMessages
	 */
	public void setReceivedMessages(final long receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	/**
	 * 
	 * @return processedMessages
	 */
	public long getProcessedMessages() {
		return processedMessages;
	}

	/**
	 * 
	 * @param processedMessages
	 */
	public void setProcessedMessages(final long processedMessages) {
		this.processedMessages = processedMessages;
	}

	/**
	 * 
	 * @return structuredBadMessages
	 */
	public long getStructuredBadMessages() {
		return structuredBadMessages;
	}

	/**
	 * 
	 * @param structuredBadMessages
	 */
	public void setStructuredBadMessages(final long structuredBadMessages) {
		this.structuredBadMessages = structuredBadMessages;
	}

	@Override
	public String toString() {
		return "PayloadResponseMessageDVO [message=" + message + ", receivedMessages=" + receivedMessages
				+ ", processedMessages=" + processedMessages + ", structuredBadMessages=" + structuredBadMessages + "]";
	}

}