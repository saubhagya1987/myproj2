package com.golenchi.web.configuration;
 
import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	Logger LOGGER = LoggerFactory.getLogger(SpringMvcInitializer.class);
	public SpringMvcInitializer(){
		LOGGER.info("Spring MVC Initializer loading");
	}
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringMVCConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
    @Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new CORSFilter()};
	}

}