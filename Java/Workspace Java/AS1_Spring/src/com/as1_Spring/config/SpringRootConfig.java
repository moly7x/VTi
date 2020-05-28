package com.as1_Spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.as1_Spring")
public class SpringRootConfig {
	//TODO: Services, DAO, DataSource, email sender or some other business layer beans	
	
}
