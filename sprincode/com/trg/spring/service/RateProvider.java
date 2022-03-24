package com.trg.spring.service;

import org.springframework.stereotype.Component;

@Component
public class RateProvider {

	public double getCoversionRate(String currency) {

		double rate = 0;
		switch (currency) {
		case "dollar":
			return 73.5;
		case "euro":
			return 92.3;
		case "pound":
			return 87.4;
		case "rouble":
			return 45.6;
		default:
			return 1;
		}
	}

}
