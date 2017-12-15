/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.mock;

import java.util.ArrayList;
import java.util.List;

import com.bursatec.rest.client.vo.MessageCommonVO;
import com.bursatec.rest.client.vo.PayloadRequestMessageDVO;
import com.bursatec.rest.client.vo.PayloadRequestMessageFinalizeVO;

/**
 * 
 * @author jbucio-badak
 * Clase que regresa un Mock utilizado en el request para una peticion HTTPS REST
 */
public class BuildRequest {
	
	public static final String RESPONSE_FINALIZE = "{\n" + 
    		"    \"listMessages\": [\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000001123338791233386 054032222000* 1233382017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000002123548431235486 054032222000* 1235482017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000003123620371236206 054032222000* 1236192017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000004123820541238206 054032222000* 1238202017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000005123959631239596 054032222000* 1239592017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000006124050071240506 054032222000* 1240492017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000007130459801304596 054032222000* 1304592017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000008130518741305186 054032222000* 1305182017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000009130537291305376 054032222000* 1305372017111400000000000000000000  FINALIZA TRANSMISION DE ERRORES  VAFINVAFIN00000                                                                                               VAFIN                                    000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000001133124441331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00001                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000002133124621331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00002                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000003133124731331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00003                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000004133124831331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00004                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000005133124901331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00005                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000006133124971331246 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00006                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000007133125021331256 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00007                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000008133125071331256 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00008                               000000\"\n" + 
    		"        },\n" + 
    		"        {\n" + 
    		"            \"message\": \"0000009133125131331256 0540322220006 0000920171020BI  CETES  171101504     NCVAFINP 000000000000010668 00701219900000009974678 007050000RV0001TNMDVAFIN00000000000000106680000120000000 00000000002000000000000000000000VAFIN00009                               000000\"\n" + 
    		"        }]}";
	
	public static final String RESPONSE_D = "{\n" + 
    		"    \"processedMessages\": 95,\n" + 
    		"    \"structuredBadMessages\": 5,\n" + 
    		"    \"receivedMessages\": 100,\n" + 
    		"    \"message\": \"success\"\n" + 
    		"}";

	/**
	 * 
	 * @param createMessages numero de mensajes mocks que se quieren crear
	 * @return regresa el un MOCK
	 */
	public static PayloadRequestMessageDVO mockMessageD(final int createMessages) {

		PayloadRequestMessageDVO payload = new PayloadRequestMessageDVO();
		List<MessageCommonVO> listMessages = new ArrayList<MessageCommonVO>();

		int count = createMessages;

		while (count > 0) {
			MessageCommonVO message = new MessageCommonVO();
			message.setMessage(
					"158D 0000120171020BI  CETES  171123000     NCVAFINP 000000000000304231 00700201000000009931924 007060000RV0001TNMDVAFIN00000000000003042310000340000000 000000000");

			listMessages.add(message);
			count--;
		}

		payload.setListMessages(listMessages);

		return payload;
	}
	
	/**
	 * 
	 * @param createMessages numero de mensajes mocks que se quieren crear
	 * @return regresa el un MOCK
	 */
	public static PayloadRequestMessageFinalizeVO mockMessageFinalize() {

		PayloadRequestMessageFinalizeVO payload = new PayloadRequestMessageFinalizeVO();


		payload.setMessage(
					"158**VAFINFINALIZA ENVIO DE CASA-CLIENTE                                                                               ");


		return payload;
	}
}
