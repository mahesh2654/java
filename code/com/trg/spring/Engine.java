
package com.trg.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	@Value("${engine.no}")
	private int engineNo;

	public int getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}

	@Override
	public String toString() {
		return "Engine [engineNo=" + engineNo + "]";
	}
	
	
}
