package org.jz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 周立《spring cloud 与Docker微服务架构实战》 Demo
 *
 * spring cloud 服务提供者
 * spring boot version -- 1.4.3.RELEASE
 * TODO 发现spring boot 2 在controller中会报错 :无法推断参数 ‘S’的类型，该类型应该继承User类，改为1.4.3版本不再报错，具体原因需要对比源码
 *
 * @author Hongyi Zheng
 */
@SpringBootApplication
public class JzpMicroserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JzpMicroserviceSimpleProviderUserApplication.class, args);
	}
}
