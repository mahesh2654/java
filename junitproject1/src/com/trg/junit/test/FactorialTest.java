package com.trg.junit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trg.junit.Util;

class FactorialTest {

	Util util;

	@BeforeEach
	public void initialize() {
		util = new Util();
	}

	@Test
	public void testFact1() {

		long fact = util.getFactorial(1);
		assertEquals(1, fact);
	}

	@Test
	public void testFact2() {
		long fact = util.getFactorial(4);
		assertEquals(24, fact);
		
	}

	@Test
	public void testFactOfZero() {
		long fact = util.getFactorial(0);
		//assertEquals(1, fact);
		
		assertTrue(fact == 1);
	}

	@Test
	public void testFactNegative() {
		try {
			long fact = util.getFactorial(-3);
			fail("Negative factorial not throwing exception");
		}
		catch(Exception ex) {
			assertTrue(true);
		}

	}

}
