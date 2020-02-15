package co.grandcircus.stringCalculator;

import static ch.lambdaj.Lambda.convert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.lambdaj.function.convert.Converter;

public class Calculator {

	public int add(String string) {
		if (string.equals("")) {
			return 0;
		} else {
			String[] addends = getAddends(string);
			List<Integer> numbers = convertToNumbers(addends);
			return sumNumbers(numbers);
		}
	}

	private String[] getAddends(String string) {
		if (string.startsWith("//")) {
			return getCustomAddends(string);
		} else {
			return string.split(",|\n");			
		}
	}

	private String[] getCustomAddends(String string) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
		m.matches();
		String customDelimiter = m.group(1);
		String numbers = m.group(2);
		return numbers.split(customDelimiter);
	}

	private int sumNumbers(List<Integer> numbers) {
		int totalSum = 0;
		for (int number : numbers) {
			totalSum += number;
		}
		return totalSum;
	}

	private List<Integer> convertToNumbers(String[] addends) {
		return convert(addends, new Converter<String, Integer>() {
			public Integer convert(String from) {
				return toInt(from);
			}
		});
	}

	private int toInt(String string) {
		return Integer.parseInt(string);
	}

}
