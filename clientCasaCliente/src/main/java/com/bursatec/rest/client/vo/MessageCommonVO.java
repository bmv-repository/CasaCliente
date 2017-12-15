/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.vo;

/**
 * @author jbucio-badak
 */
public class MessageCommonVO {
	/**
	 * mensaje.
	 */
	private String message;

	/**
	 * @return message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Constructor por defecto
	 */
	public MessageCommonVO() {

	}

	/**
	 * Contructor con parametros
	 * 
	 * @param message
	 */
	public MessageCommonVO(final String message) {
		super();
		this.message = message;
	}

	/**
	 * @param message
	 *            mensaje.
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageCommonVO [message=" + message + "]";
	}

}
