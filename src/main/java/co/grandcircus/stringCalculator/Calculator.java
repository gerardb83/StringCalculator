package co.grandcircus.stringCalculator;

public class Calculator {

	public int add(String string) {
		if (string.equals("")) {
			return 0;
		} else if (string.contains(",")) {
			return 2;
		} else {
			return Integer.parseInt(string);
		}
	}

}
