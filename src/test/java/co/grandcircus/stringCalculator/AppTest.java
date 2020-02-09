package co.grandcircus.stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {

	
	@Test
	public void whenEmptyIsPassedReturns0() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void whenOneIsPassedReturns1() {
		Calculator calculator = new Calculator();
		assertEquals(1, calculator.add("1"));
	}

}
