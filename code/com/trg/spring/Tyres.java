package com.trg.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tyres {
	
	@Value("${tyres.brand}")
	private String tyreBrand;

	public String getTyreBrand() {
		return tyreBrand;
	}

	public void setTyreBrand(String tyreBrand) {
		this.tyreBrand = tyreBrand;
	}

	@Override
	public String toString() {
		return "Tyres [tyreBrand=" + tyreBrand + "]";
	}
	

}
