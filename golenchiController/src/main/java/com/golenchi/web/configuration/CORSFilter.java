package com.golenchi.web.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
			System.out.println("in init");
			}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			res.setHeader("Access-Control-Max-Age", "3600");
			res.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
			res.setHeader("Content-Type", "application/json");
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
