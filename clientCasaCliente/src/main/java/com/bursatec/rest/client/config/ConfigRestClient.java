/**
 * Bursatec - BMV 08/11/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.rest.client.config;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * @author jbucio-badak 
 * Configuracion de un cliente rest
 */
public class ConfigRestClient {

    /**
     * path del certificado.
     */
    private static String SSL_TRUST_STORE;

    /**
     * Carga el certificado autofirmado y permite la conexion mediate HTTPS.
     */
    private void loadTrustStore() {

        System.setProperty("javax.net.ssl.trustStore", SSL_TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

            public boolean verify(final String s, final SSLSession sslSession) {
                return true;
            }

        });
    }

    /**
     * Cliente HTTP.
     */
    private Client client;

    /**
     * URL que se invocara.
     */
    private WebTarget webTarget;

    /**
     * Constructor para inicializar el cliente.
     * 
     * @param host ip del Web Service
     * @param port puerto del Web Service
     * @param path path del Web Service
     */
    public ConfigRestClient(final String host, final String port,
            final String path, final String keystorePath) {

        this.SSL_TRUST_STORE = keystorePath;
        loadTrustStore();
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target("https://" + host + ":" + port)
                .path(path);
    }

    /**
     * @return webTarget
     */
    public WebTarget getWebTarget() {
        return webTarget;
    }

}
