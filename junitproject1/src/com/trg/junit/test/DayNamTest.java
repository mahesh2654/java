package com.trg.junit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.trg.junit.Util;

class DayNamTest {

	@Test
	void testSunday() {

		assertEquals("Sunday", Util.getDayName(1));
	}

	@Test
	void testFriday() {

		assertEquals("Friday", Util.getDayName(6));
	}

	@Test
	void testNegativeDay() {

		assertNull(Util.getDayName(-5));
	}

	@Test
	void testOutOfRangeValue() {

		assertNull(Util.getDayName(21));
	}

}
