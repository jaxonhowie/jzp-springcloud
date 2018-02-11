package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * api platform
 *
 * @author Hongyi Zheng
 * @date 2018-2-8
 *
 */
@EnableEurekaClient
@EnableAutoConfiguration()
@ComponentScan
@SpringBootApplication
public class JzpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpApiApplication.class, args);
	}
}
