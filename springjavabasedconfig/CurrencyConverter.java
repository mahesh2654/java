package com.cg.trg.beans;

public class CurrencyConverter {

	private double conversionrate;
	private String currency;

	public CurrencyConverter(double conversionrate) {
		super();
		this.conversionrate = conversionrate;
		currency = "dollars";
	}

	public CurrencyConverter(double conversionrate, String currency) {
		super();
		this.conversionrate = conversionrate;
		this.currency = currency;
	}

	public double convertToRupees(double currency) {
		return currency * conversionrate;
	}

	public double convertFromRupees(double currency) {
		return currency / conversionrate;
	}

	public String getCurrency() {
		return currency;
	}

	public double getConversionrate() {
		return conversionrate;
	}

}