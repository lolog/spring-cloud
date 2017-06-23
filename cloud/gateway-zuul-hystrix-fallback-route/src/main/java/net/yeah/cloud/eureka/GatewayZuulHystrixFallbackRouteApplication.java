package net.yeah.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulHystrixFallbackRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulHystrixFallbackRouteApplication.class, args);
	}
}
