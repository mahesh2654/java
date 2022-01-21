package com.trg.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	private Engine engine;
	@Autowired
	private Body body;
	@Autowired
	private Tyres tyres;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Tyres getTyres() {
		return tyres;
	}

	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}

	@Override
	public String toString() {
		return "Car \nengine=" + engine + "\n body=" + body + "\ntyres=" + tyres + "]";
	}

}
