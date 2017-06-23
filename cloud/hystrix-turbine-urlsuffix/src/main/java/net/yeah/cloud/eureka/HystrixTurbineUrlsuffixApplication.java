package net.yeah.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class HystrixTurbineUrlsuffixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineUrlsuffixApplication.class, args);
	}
}
