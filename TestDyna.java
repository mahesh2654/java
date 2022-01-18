package com.test.dyna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

class TestDyna {

	@TestFactory
	public Collection<DynamicTest> translateDynamicTests() {

		List<String> inPhrases = new ArrayList<>(
				Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
		List<String> outPhrases = new ArrayList<>(
				Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < inPhrases.size(); i++) {

			String phr = inPhrases.get(i);
			String outPhr = outPhrases.get(i);

			// create an test execution
			Executable exec = () -> assertEquals(outPhr, TranslatorEngine.tranlate(phr));

			// create a test display name
			String testName = "Test tranlate " + phr;
			// create dynamic test
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

			// add the dynamic test to collection
			dynamicTests.add(dTest);
		}
		return dynamicTests;
	}

}
