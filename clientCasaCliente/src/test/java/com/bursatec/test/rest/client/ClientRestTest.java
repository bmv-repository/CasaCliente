/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.test.rest.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import static org.junit.Assert.assertEquals;

import java.net.URL;


import org.junit.Rule;
import org.junit.Test;

import com.bursatec.rest.client.RestClient;
import com.bursatec.rest.client.mock.BuildRequest;
import com.bursatec.rest.client.vo.PayloadVO;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

/**
 * 
    * @author jbucio-badak - Bursatec
    * @version 1.0
 */
public class ClientRestTest {
	
    
    
    /**
     * URL del path del certificado para el servidor https. 
     */
    private final URL location = ClientRestTest.class.getResource("/keystore2.jks");
    
    /**
     * String del path para el certificado. 
     */
    private final String keystorePath = location.getPath();
    
    /**
     * Mock de un servidor https.
     */
    @Rule
    public WireMockRule wireMock = new WireMockRule(wireMockConfig()
            .httpsPort(8443)
            .keystorePath(keystorePath)
            .keystorePassword("12345678"));

    /**
     * mensaje tipo D
     * test para mensaje 200-.
     * Indica que la peticion fue exitosa
     */
    @Test
    public void sendMessagesDToCasaClienteResponse200() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/messages"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(BuildRequest.RESPONSE_D)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/messages",
                keystorePath,
                BuildRequest.mockMessageD(3),PayloadVO.TypeResponse.RESPONSE_D);
        
        System.out.println(response.toString());
        assertEquals(200, response.getCodeHTTP());
    }
    /**
     * mensaje tipo D
     * test para mensajes 401-.
     * que indica que es una ip no permitida para el consumo del servicio
     */
    @Test
    public void sendMessagesDToCasaClienteResponse401() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/messages"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Ip no permitida")
                        .withStatus(401)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/messages",
                keystorePath,
                BuildRequest.mockMessageD(3),PayloadVO.TypeResponse.RESPONSE_D);
        
        System.out.println(response.toString());
        assertEquals(401, response.getCodeHTTP());
    }
    
    /**
     * mensaje Finaliza
     * test para mensaje 200-.
     * Indica que la peticion fue exitosa
     */
    @Test
    public void sendMessagesFinalizeToCasaClienteResponse200() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/finalize"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(BuildRequest.RESPONSE_FINALIZE)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/finalize",
                keystorePath,
                BuildRequest.mockMessageFinalize(),PayloadVO.TypeResponse.RESPONSE_FINALIZE);
        
        System.out.println(response.toString());
        assertEquals(200, response.getCodeHTTP());
    }
    
    
    /**
     * mensaje Finaliza
     * test para mensaje 404-.
     * Indica que la peticion fue exitosa
     */
    @Test
    public void sendMessagesFinalizeToCasaClienteResponse404() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/finalize"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Mensajes Finaliza no encontrados")
                        .withStatus(404)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/finalize",
                keystorePath,
                BuildRequest.mockMessageFinalize(),PayloadVO.TypeResponse.RESPONSE_FINALIZE);
        
        System.out.println(response.toString());
        assertEquals(404, response.getCodeHTTP());
    }
    
    /**
     * mensaje Finalize
     * test para mensajes 401-.
     * que indica que es una ip no permitida para el consumo del servicio
     */
    @Test
    public void sendMessagesFinalizeToCasaClienteResponse401() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/finalize"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Ip no permitida")
                        .withStatus(401)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/finalize",
                keystorePath,
                BuildRequest.mockMessageFinalize(),PayloadVO.TypeResponse.RESPONSE_FINALIZE);
        
        System.out.println(response.toString());
        assertEquals(401, response.getCodeHTTP());
    }

    /**
     * mensaje Finalize
     * test para mensajes 500-.
     * que indica que es una ip no permitida para el consumo del servicio
     */
    @Test
    public void sendMessagesFinalizeToCasaClienteResponse500() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/finalize"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Internal Server Error ....")
                        .withStatus(500)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/finalize",
                keystorePath,
                BuildRequest.mockMessageFinalize(),PayloadVO.TypeResponse.RESPONSE_FINALIZE);
        
        System.out.println(response.toString());
        assertEquals(500, response.getCodeHTTP());
    }
    
    /**
     * mensaje Finalize
     * test para mensajes 400-.
     * que indica que es una ip no permitida para el consumo del servicio
     */
    @Test
    public void sendMessagesFinalizeToCasaClienteResponse400() {

        stubFor(post(urlEqualTo("/CasaClienteService/transmision/finalize"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Mensaje mal estructurado")
                        .withStatus(400)));

        RestClient client = new RestClient();

        PayloadVO response = client.sendMessages("localhost", "8443",
                "/CasaClienteService/transmision/finalize",
                keystorePath,
                BuildRequest.mockMessageFinalize(),PayloadVO.TypeResponse.RESPONSE_FINALIZE);
        
        System.out.println(response.toString());
        assertEquals(400, response.getCodeHTTP());
    }
}
