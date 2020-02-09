package co.grandcircus.stringCalculator;

public class Calculator {

	public int add(String string) {
		if (string.equals("")) {
			return 0;
		} else if (string.contains(",")) {
			String [] addends = string.split(",");
			return Integer.parseInt(addends[0]) + Integer.parseInt(addends[1]);
		} else {
			return Integer.parseInt(string);
		}
	}

}
