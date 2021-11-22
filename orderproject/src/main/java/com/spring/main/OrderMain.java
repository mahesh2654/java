package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ProjectConfig;

import com.spring.beans.Order;

public class OrderMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

		Order ord = (Order) ctx.getBean("order");

		System.out.println(ord);
	}
}
