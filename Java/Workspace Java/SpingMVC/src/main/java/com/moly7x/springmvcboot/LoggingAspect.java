//
package com.moly7x.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public final class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.moly7x.springmvcboot.AilenController.getAilens())")
	public void logBefore() {
		LOGGER.info("getAilens method called");
	}
	
	@After("execution(public * com.moly7x.springmvcboot.AilenController.getAilens())")
	public void logAfter() {
		LOGGER.info("getAilens method executed");
	}
	
}
