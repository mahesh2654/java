package com.trg.anno.beans;

import org.springframework.stereotype.Service;

@Service
public class ConversionRateProvider {

	public double getRate(String currency) {

		switch (currency) {
			case "dollar":
				return 72.5;
			case "euro":
				return 102.6;
			case "pound":
				return 92.6;
			default:
				return 1;
		}
	}

}
