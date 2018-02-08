package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * api platform
 *
 * @author Hongyi Zheng
 * @date 2018-2-8
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class JzpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpApiApplication.class, args);
	}
}
