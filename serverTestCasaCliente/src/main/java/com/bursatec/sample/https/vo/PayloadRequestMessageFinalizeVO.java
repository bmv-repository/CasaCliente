/**
 * Bursatec - BMV 14/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.sample.https.vo;

/**
 * 
 * @author jbucio-badak
 *
 */
public class PayloadRequestMessageFinalizeVO {

	/**
	 * mensaje
	 */
	private String message;

	/**
	 * cosntructor sin argumentos
	 */
	public PayloadRequestMessageFinalizeVO() {
	}

	/**
	 * constructor con argumentos
	 * 
	 * @param message
	 */
	public PayloadRequestMessageFinalizeVO(final String message) {
		super();
		this.message = message;
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

	@Override
	public String toString() {
		return "PayloadRequestMessageFinalizeVO [message=" + message + "]";
	}

}
