package com.trg.anno.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {

	// @Value("${converter.currency.rate}")
	// private double conversionrate;

	@Value("${currency.name}")
	private String currency;

	@Autowired
	private ConversionRateProvider rateProvider;

	public double convertToRupees(double value) {
		return value * rateProvider.getRate(currency);
	}

	public double convertFromRupees(double value) {
		return value / rateProvider.getRate(currency);
	}

	public String getCurrency() {
		return currency;
	}

	@PostConstruct
	public void m1() {
		System.out.println("Converter Bean created");
	}

	@PreDestroy
	public void m2() {
		System.out.println("Converter Bean destroyed");
	}

}