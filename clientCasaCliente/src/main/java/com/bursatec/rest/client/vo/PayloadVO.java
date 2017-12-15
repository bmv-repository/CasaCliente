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
 * @author jbucio-badak
 *
 */
public class PayloadVO {

	/**
	 * codigo HTTP
	 */
	private int codeHTTP;

	/**
	 * razon del codigo HTTP
	 */
	private String reason;

	/**
	 * Lista de mensajes
	 */
	private List<MessageCommonVO> listMessages;
	
	

	public PayloadVO(final int codeHTTP,final  String reason,final  List<MessageCommonVO> listMessages) {
		super();
		this.codeHTTP = codeHTTP;
		this.reason = reason;
		this.listMessages = listMessages;
	}

	/**
	 * 
	 * @return codeHTTP
	 */
	public int getCodeHTTP() {
		return codeHTTP;
	}

	/**
	 * 
	 * @param codeHTTP
	 *            codigo http
	 */
	public void setCodeHTTP(final int codeHTTP) {
		this.codeHTTP = codeHTTP;
	}

	/**
	 * 
	 * @return razon del codigo http
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 
	 * @param reason
	 *            razpn del codigo http
	 */
	public void setReason(final String reason) {
		this.reason = reason;
	}

	/**
	 * 
	 * @return listMessages lista de mensajes
	 */
	public List<MessageCommonVO> getListMessages() {
		return listMessages;
	}

	/**
	 * 
	 * @param listMessages
	 *            lista de mensajes
	 */
	public void setListMessages(final List<MessageCommonVO> listMessages) {
		this.listMessages = listMessages;
	}

	@Override
	public String toString() {
		return "PayloadVO [codeHTTP=" + codeHTTP + ", reason=" + reason + ", listMessages=" + listMessages + "]";
	}
	
	/**
	 * Enumerador utilizado para construir el response generico
	 * @author jbucio-badak
	 *
	 */
	public enum TypeResponse {
		
		RESPONSE_D,
		RESPONSE_FINALIZE
		
	}

}
