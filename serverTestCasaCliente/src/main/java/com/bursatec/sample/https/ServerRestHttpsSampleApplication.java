/**
 * Bursatec - BMV 07/12/2017
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
 */
package com.bursatec.sample.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Clase Principal
    * @author jbucio-badak - Bursatec
    * @version 1.0
 */
@SpringBootApplication
public class ServerRestHttpsSampleApplication {

    /**
     * Metodo para iniciar el proyecto con Spring Boot
        * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(ServerRestHttpsSampleApplication.class, args);
	}
}
