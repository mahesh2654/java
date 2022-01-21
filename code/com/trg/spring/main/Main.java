package com.trg.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trg.spring.Car;
import com.trg.spring.Employee;

public class Main {

	public static void main(String[] args) {

		// create container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		Employee e = (Employee) ctx.getBean("employee");
		System.out.println(e);

		
		Car c1 = (Car) ctx.getBean("car");
		System.out.println(c1);
		ctx.close();
	}

}
