package net.yeah.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerCryptRsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerCryptRsaApplication.class, args);
	}
}
