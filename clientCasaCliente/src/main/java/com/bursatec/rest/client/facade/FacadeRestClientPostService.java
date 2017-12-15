/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bursatec.rest.client.config.ConfigRestClient;
import com.bursatec.rest.client.vo.MessageCommonVO;
import com.bursatec.rest.client.vo.PayloadResponseMessageDVO;
import com.bursatec.rest.client.vo.PayloadResponseMessageFinalizeVO;
import com.bursatec.rest.client.vo.PayloadVO;

/**
 * @author jbucio-badak Clase para la invocacion del servicio rest mediante post
 */
public abstract class FacadeRestClientPostService {

	/**
	 * Cliente Rest.
	 */
	private ConfigRestClient restClient;
	/**
	 * Respuesta de una peticion HTTP.
	 */
	private Response response;

	/**
	 * Se inicializa el cliente rest.
	 * 
	 * @param host
	 *            ip del Web Service
	 * @param port
	 *            puerto del Web Service
	 * @param urlPath
	 *            path del Web Service
	 * @param keystorePath
	 *            path del ssl
	 */
	private void initRestClient(final String host, final String port, final String urlPath, final String keystorePath) {
		restClient = new ConfigRestClient(host, port, urlPath, keystorePath);
	}

	/**
	 * Realiza una peticion via HTTPS.
	 * 
	 * @param host
	 *            ip del Web Service
	 * @param port
	 *            puerto del Web Service
	 * @param urlPath
	 *            path del Web Service
	 * @param keystorePath
	 *            path del ssl
	 * @param request
	 *            peticion
	 */
	protected final void invokeHTTPS(final String host, final String port, final String urlPath,
			final String keystorePath, final Object request) {

		// Se crea el cliente rest
		initRestClient(host, port, urlPath, keystorePath);

		// Se realiza la peticion HTTPS
		Invocation.Builder invocationBuilder = restClient.getWebTarget().request(MediaType.APPLICATION_JSON_TYPE);
		response = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));

	}

	/**
	 * Metodo abstracto para la invocacion del servicio.
	 * 
	 * @param host
	 *            ip del Web Service
	 * @param port
	 *            puerto del Web Service
	 * @param urlPath
	 *            path del Web Service
	 * @param keystorePath
	 *            path del ssl
	 * @param request
	 *            peticion
	 * @return this.response.
	 */
	public abstract PayloadVO sendMessages(final String host, final String port, final String urlPath,
			final String keystorePath, final Object request, final PayloadVO.TypeResponse typeResponse);

	protected PayloadVO buildResponse(Response response, PayloadVO.TypeResponse typeResponse) {
		List<MessageCommonVO> listMessages = new ArrayList<>();

		switch (this.getResponse().getStatus()) {

		case 200:

			switch (typeResponse) {
			case RESPONSE_D:

				PayloadResponseMessageDVO prD = response.readEntity(PayloadResponseMessageDVO.class);
				listMessages.add(new MessageCommonVO("mensajes recibidos: " + prD.getReceivedMessages()));
				listMessages.add(new MessageCommonVO("mensajes procesados: " + prD.getProcessedMessages()));
				listMessages.add(new MessageCommonVO("mensajes mal Estructurados: " + prD.getStructuredBadMessages()));

				return new PayloadVO(this.getResponse().getStatus(),
						this.getResponse().getStatusInfo().getReasonPhrase(), listMessages);

			case RESPONSE_FINALIZE:

				PayloadResponseMessageFinalizeVO prFinalize = response
						.readEntity(PayloadResponseMessageFinalizeVO.class);
				for (MessageCommonVO messageCommonVO : prFinalize.getListMessages()) {
					listMessages.add(messageCommonVO);
				}

				return new PayloadVO(this.getResponse().getStatus(),
						this.getResponse().getStatusInfo().getReasonPhrase(), listMessages);
			}

		default:

			String res = response.readEntity(String.class);
			listMessages.add(new MessageCommonVO(res));

			return new PayloadVO(this.getResponse().getStatus(), this.getResponse().getStatusInfo().getReasonPhrase(),
					listMessages);
		}
	}

	/**
	 * @return response.
	 */
	public Response getResponse() {
		return response;
	}

}
