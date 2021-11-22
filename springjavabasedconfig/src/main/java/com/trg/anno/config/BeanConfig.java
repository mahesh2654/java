package com.trg.anno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com"})
@PropertySource(value = "app.properties")
public class BeanConfig {

	
	
}
