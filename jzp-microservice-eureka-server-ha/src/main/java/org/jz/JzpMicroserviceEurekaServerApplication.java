package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Hongyi Zheng
 */
@SpringBootApplication
@EnableEurekaServer
public class JzpMicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpMicroserviceEurekaServerApplication.class, args);
	}
}
