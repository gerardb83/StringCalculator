package co.grandcircus.stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.internal.runners.statements.Fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

	private Calculator calculator;
	
	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void whenEmptyIsPassedReturns0() {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void whenOnePositiveNumberIsPassedReturnsThatNumber() {
		assertEquals(1, calculator.add("1"));
		assertEquals(10, calculator.add("10"));
	}

	@Test
	public void whenTwoPositiveNumberArePassedReturnsTheSum() {
		assertEquals(2, calculator.add("1,1"));
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void whenMultiplePositiveNumberArePassedReturnsTheSum() {
		assertEquals(6, calculator.add("1,2,3"));
	}
	
	@Test
	public void whenNewlinePassedAsDelimiterItIsRecognized() {
		assertEquals(6, calculator.add("1,2\n3"));
	}
	
	@Test
	public void whenCustomDelimiterIsUsedItIsRecognized() {
		assertEquals(3, calculator.add("//;\n1;2"));
		assertEquals(5, calculator.add("//;\n1;2;2"));
		assertEquals(5, calculator.add("//%\n1%2%2"));
	}
	
	@Test
	public void whenNegativeNumbersArePassed() {
		try {
			calculator.add("-1,2,3");
			fail("exception expected");
		} catch(RuntimeException ex) {
		}
	}
	
	@Test
	public void exceptionMessageContainsNegativeNumbers() {
		try {
			calculator.add("-1,2,3");
			fail("exception expected");
		} catch(RuntimeException ex) {
			assertEquals("Negatives forbidden: [-1]", ex.getMessage());
		}
		
	}
}
