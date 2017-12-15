/**
 * Bursatec - BMV 09/12/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.test.rest.client;

import java.net.URL;

import com.bursatec.rest.client.RestClient;
import com.bursatec.rest.client.mock.BuildRequest;
import com.bursatec.rest.client.vo.PayloadVO;

/**
 * @author jbucio-badak - Bursatec
 * @version 1.0
 */
public class FunctionalTest {

    /**
     * Metodo main
     * 
     * @param args
     */
    public static void main(String[] args) {

        String pathKeystore = loadKeystore();

        funcionalTestMessagesD(pathKeystore);
        funcionalTestMessagesFinalize(pathKeystore);

    }

    /**
     * Se obtiene el certificado para la conexion HTTPS.
     * 
     * @return
     */
    public static String loadKeystore() {
        URL location = FunctionalTest.class.getResource("/keystore2.jks");
        String fullPath = location.getPath();

        return fullPath;
    }

    /**
     * Test funcional para la implementacion, de un envio de mensaje D
     * 
     * @param pathKeystore
     */
    public static void funcionalTestMessagesD(final String pathKeystore) {

        RestClient rc = new RestClient();

        PayloadVO response = rc.sendMessages("localhost", "9998",
                "/CasaClienteService/transmision/messages", pathKeystore,
                BuildRequest.mockMessageD(5),
                PayloadVO.TypeResponse.RESPONSE_D);

        System.out.println(
                "Respuesta de Mensajes [/CasaClienteService/transmision/messages] : "
                        + response);
    }

    /**
     * Test funcional para la implementacion, de un envio de mensaje finaliza.
     * 
     * @param pathKeystore
     */
    public static void funcionalTestMessagesFinalize(
            final String pathKeystore) {

        RestClient rc = new RestClient();

        PayloadVO response = rc.sendMessages("localhost", "9998",
                "/CasaClienteService/transmision/finalize", pathKeystore,
                BuildRequest.mockMessageFinalize(),
                PayloadVO.TypeResponse.RESPONSE_FINALIZE);

        System.out.println(
                "Respuesta de Mensajes [/CasaClienteService/transmision/finalize] : "
                        + response);
    }

}
