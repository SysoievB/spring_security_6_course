package com.section_12_oauth2_keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class Section10MethodLevelSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section10MethodLevelSecurityApplication.class, args);
	}

}
