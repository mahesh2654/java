package com.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.beans.Item;
import com.spring.beans.Order;

@Configuration
@ComponentScan(basePackages = "com")
public class ProjectConfig {

	@Bean(name = "item1")
	public Item getItem1() {
		return new Item(100, "Heavy Tools", 25000);

	}

	@Bean(name = "item2")
	public Item getItem2() {
		return new Item(200, "Machinery", 55000);

	}

	@Bean(name = "order")
	public Order getOrder() {

		Order ord = new Order(1234, LocalDate.now());
		return ord;

	}

}
