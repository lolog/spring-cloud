package net.yeah.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulFilterApplication.class, args);
	}
}
