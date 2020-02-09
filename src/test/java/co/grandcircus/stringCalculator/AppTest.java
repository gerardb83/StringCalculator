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
	public void whenOnePositiveNumberIsPassedReturnsThatNumber() {
		Calculator calculator = new Calculator();
		assertEquals(1, calculator.add("1"));
		assertEquals(10, calculator.add("10"));
	}

}
