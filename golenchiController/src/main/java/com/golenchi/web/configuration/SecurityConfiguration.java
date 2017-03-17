package com.golenchi.web.configuration;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
@ImportResource(value="classpath:spring-security.xml")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
	public  SecurityConfiguration() {
		LOGGER.info("********* LOADING SECURITY CONFIGURATION ************");
	}	
}