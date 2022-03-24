package com.trg.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("converter")
public class CurrencyConverter {

	@Autowired
	private RateProvider provider;

	//@Value("${currency}")
	String currency="dollar";

	
	public String getCurrency() {
		return currency;
	}
	public double convertToRupees(double amount) {
		double rate = provider.getCoversionRate(currency);

		double convertedValue = amount * rate;
		return convertedValue;
	}

	public double convertFromRupees(double amount) {

		double rate = provider.getCoversionRate(currency);

		double convertedValue = amount / rate;
		return convertedValue;
	}
}
