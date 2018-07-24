package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@EnableTransactionManagement
@Configuration
public class JzpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpApiApplication.class,args);
	}

	
}
