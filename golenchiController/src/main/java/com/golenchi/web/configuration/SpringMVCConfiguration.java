package com.golenchi.web.configuration;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.google.gson.Gson;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.golenchi")
@Import(value = SecurityConfiguration.class)
@ImportResource(value = "classpath:applicationContext.xml")
public class SpringMVCConfiguration {

	Logger LOGGER = LoggerFactory.getLogger(SpringMVCConfiguration.class);

	@Bean(name = "plaintextPasswordEncoder")
	public PlaintextPasswordEncoder getPlaintextPasswordEncoder() {
		PlaintextPasswordEncoder encoder = new PlaintextPasswordEncoder();
		return encoder;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public MessageSource getMessageSource() {
		String[] basenames = new String[] {};
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(basenames);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(3);
		return messageSource;
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}
	
	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

}