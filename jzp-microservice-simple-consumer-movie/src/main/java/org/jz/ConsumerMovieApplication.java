package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 周立《spring cloud 与Docker微服务架构实战》 Demo
 *
 * spring cloud 服务消费者
 * spring boot version -- 2.0.0.RELEASE
 *
 * @author Hongyi Zheng
 */
@SpringBootApplication
public class ConsumerMovieApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieApplication.class, args);
	}
}
