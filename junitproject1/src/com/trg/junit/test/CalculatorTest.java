package com.trg.junit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.trg.junit.Calculator;

import static java.lang.System.out;

class CalculatorTest {
	
	@BeforeEach
	public void beforeMethod() {
		out.println("test started");
	}

	@Test
	@Disabled
	public void testAdd1() {
		
		Calculator calc= new Calculator();
		int sum = calc.add(30, 40);
		assertEquals(70,sum);
	}

	

	@Test
	public void testAdd2() {
		
		Calculator calc= new Calculator();
		int sum = calc.add(30, -40);
		assertEquals(-10,sum);

	}
	
	@Test
	public void testDivide1() {
		Calculator calc= new Calculator();
		int div = calc.divide(30, 5);
		
		assertEquals(6,div);
	}
	


}
