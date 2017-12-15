/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client;

import com.bursatec.rest.client.facade.FacadeRestClientPostService;
import com.bursatec.rest.client.vo.PayloadVO;

/**
 * @author jbucio-badak - Bursatec
 * @version 1.0
 */
public class RestClient extends FacadeRestClientPostService {
	/**
	 * implementacion para el envio de mensajes.
	 */
	@Override
	public PayloadVO sendMessages(final String host, final String port, final String urlPath, final String keystorePath,
			final Object request,final PayloadVO.TypeResponse typeResponse) {

		invokeHTTPS(host, port, urlPath, keystorePath, request);

		return buildResponse(this.getResponse(), typeResponse);

	}

}
