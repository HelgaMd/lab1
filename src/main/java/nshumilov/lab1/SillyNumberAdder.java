package nshumilov.lab1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SillyNumberAdder {
	private static Pattern customDelimiterPattern = Pattern.compile("//(.*)\\n(.*)");

	/**
	 * Does the thing specified in README.md
	 *
	 * @param numbers the number string
	 * @return sum of the numbers present in the string
	 */
	public static int add(String numbers) {
		//Handle empty string
		if (numbers.isEmpty())
			return 0;

		//Extract customSeparators if present
		String customSeparators;
		String separatedNumbers;
		Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
		if (customDelimiterMatcher.matches()) {
			customSeparators = customDelimiterMatcher.group(1);
			separatedNumbers = customDelimiterMatcher.group(2);
		} else {
			customSeparators = null;
			separatedNumbers = numbers;
		}

		//Obtain number string split regex
		String splitRegex = getSplitRegex(customSeparators);

		//Calculate the sum
		OptionalInt result;
		try {
			result = Arrays
					.stream(separatedNumbers.split(splitRegex))
					.mapToInt(Integer::valueOf)
					.filter(value -> value <= 1000)
					.reduce(Integer::sum);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}

		//Return result
		return result.isPresent() ? result.getAsInt() : 0;
	}

	/**
	 * Returns the regex used while splitting the number string
	 *
	 * @param customSeparators custom separator string
	 * @return the split regex
	 */
	private static String getSplitRegex(String customSeparators) {
		return customSeparators != null ? customSeparators : ",|\\n";
	}

	/**
	 * Just an entry point for debugging
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		add("//; \n1; 2");
	}
}
