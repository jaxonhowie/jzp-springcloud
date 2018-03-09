package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * api platform
 *
 * @author Hongyi Zheng
 * @date 2018-2-8
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableTransactionManagement
@Configuration
@EnableEurekaClient
public class JzpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpApiApplication.class, args);
	}

	
}
