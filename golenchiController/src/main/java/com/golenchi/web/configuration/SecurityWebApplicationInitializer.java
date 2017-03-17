package com.golenchi.web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	Logger LOGGER = LoggerFactory.getLogger(SecurityWebApplicationInitializer.class);
	public SecurityWebApplicationInitializer() {
		LOGGER.info("Security Web Application Initializer loading");
	}

	
}