//
package com.as1_Spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 28/05/2020
 */
public class ContactApplicationDispathcerSevletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/* 
	* @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringRootConfig.class};
	}

	/* 
	* @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	*/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringWebConfig.class};
	}

	/* 
	* @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	*/
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	/* 
	* @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup(javax.servlet.ServletContext)
	*/
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}

}
