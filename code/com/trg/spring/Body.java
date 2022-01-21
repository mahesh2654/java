package com.trg.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Body {
	
	@Value("${body.no}")
	private int bodyNo;

	public int getBodyNo() {
		return bodyNo;
	}

	public void setBodyNo(int bodyNo) {
		this.bodyNo = bodyNo;
	}

	@Override
	public String toString() {
		return "Body [bodyNo=" + bodyNo + "]";
	}
	
	

}
