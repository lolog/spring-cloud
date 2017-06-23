package net.yeah.cloud.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerMovieFeignWithHystrixFallbackFactoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignWithHystrixFallbackFactoryApplication.class, args);
	}
}
