package org.oschina.zb.bi.app;

import org.oschina.zb.platform.utils.logger.LoggerUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "org.oschina.zb.bi", "org.oschina.zb.platform" })
@EnableScheduling
@EnableFeignClients
public class BIApplication {
	private static LoggerUtils logger = LoggerUtils.getLogger(BIApplication.class);

	@Value("${spring.profiles.active}")
	private String RUNNING_ENVIRONMENT;

	public static void main(String[] args) {
		SpringApplication.run(BIApplication.class, args);
	}

	@Bean
	public BIApplication test() {
		logger.info("运行环境----------：" + RUNNING_ENVIRONMENT);
		return null;
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
