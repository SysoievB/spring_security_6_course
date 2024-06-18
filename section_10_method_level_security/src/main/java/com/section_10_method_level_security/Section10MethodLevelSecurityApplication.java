package com.section_10_method_level_security;

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
