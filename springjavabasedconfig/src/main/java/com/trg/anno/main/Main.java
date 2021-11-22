package com.trg.anno.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trg.anno.beans.CurrencyConverter;
import com.trg.anno.config.BeanConfig;

public class Main {

	public static void main(String[] args) throws IOException {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

		CurrencyConverter con = (CurrencyConverter) ctx.getBean("currencyConverter");
		System.out.println("4500 " + con.getCurrency() + "s converted to Rupees is " + con.convertToRupees(4500));
		
		System.out.println("4500 rupees converted to "+con.getCurrency()+"s is "+con.convertFromRupees(4500));
		
		((AnnotationConfigApplicationContext) ctx).close();
	}

}
