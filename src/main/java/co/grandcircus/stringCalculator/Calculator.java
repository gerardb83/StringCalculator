package co.grandcircus.stringCalculator;

import static ch.lambdaj.Lambda.convert;


import java.util.List;
import ch.lambdaj.function.convert.Converter;

public class Calculator {

	public int add(String string) {
		if (string.equals("")) {
			return 0;
		} else if (string.contains(",")) {
			String [] addends = string.split(",");
			List<Integer> numbers = convertToNumbers(addends);		
			return sumNumbers(numbers);
						
		} else {
			return toInt(string);
		}
	}

	private int sumNumbers(List<Integer> numbers) {
		int totalSum = 0;
		for(int number: numbers) {
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
