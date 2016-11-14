package nshumilov.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SillyNumberAdder {
	private static Pattern customDelimiterPattern = Pattern.compile("//(.*)\\n(.*)");
	private static Pattern singleCharDelimiterPattern = Pattern.compile(".");
	private static Pattern multiCharDelimitersPattern = Pattern.compile("(?:\\[[^\\[\\]]+\\])+");
	private static Pattern multiCharDelimiterPattern = Pattern.compile("\\[([^\\[\\]]+)\\]");

	/**
	 * Does the thing specified in README.md
	 *
	 * @param numbers the number string
	 * @return sum of the numbers present in the string
	 * @throws NegativesNotAllowedException if at least one negative number is present
	 * @throws IllegalArgumentException     if the number string is malformed in some way
	 */
	public static int add(String numbers) {
		//Handle an empty string
		if (numbers.isEmpty())
			return 0;

		//Extract custom delimiters if present
		String customDelimiters;
		Matcher customDelimiterMatcher = customDelimiterPattern.matcher(numbers);
		if (customDelimiterMatcher.matches()) {
			customDelimiters = customDelimiterMatcher.group(1);
			numbers = customDelimiterMatcher.group(2);
		} else {
			customDelimiters = null;
		}

		//Split the numbers
		String splitRegex = getSplitRegex(customDelimiters);
		String[] splitNumbers = numbers.split(splitRegex);

		//Process the numbers
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();
		try {
			for (String s : splitNumbers) {
				int number = Integer.parseInt(s);
				if (number < 0)
					negativeNumbers.add(number);
				else if (number <= 1000)
					sum += number;
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Number substring is malformed: " + numbers, e);
		}
		if (!negativeNumbers.isEmpty()) {
			throw new NegativesNotAllowedException(negativeNumbers);
		}

		//Return the sum
		return sum;
	}

	/**
	 * Returns the regex used while splitting the number string
	 *
	 * @param customDelimiters custom delimiter string
	 * @return the split regex
	 */
	private static String getSplitRegex(String customDelimiters) {
		if (customDelimiters == null)
			return ",|\\n";

		List<String> delimiters = new ArrayList<>();
		Matcher singleCharDelimiter = singleCharDelimiterPattern.matcher(customDelimiters);
		Matcher multiCharDelimiters = multiCharDelimitersPattern.matcher(customDelimiters);
		Matcher multiCharDelimiter = multiCharDelimiterPattern.matcher(customDelimiters);

		if (singleCharDelimiter.matches()) {
			return customDelimiters;
		} else if (multiCharDelimiters.matches()) {
			while (multiCharDelimiter.find()) {
				delimiters.add(multiCharDelimiter.group(1));
			}
		} else {
			throw new IllegalArgumentException("Illegal custom delimiters substring: " + customDelimiters);
		}

		return delimiters.stream().map(Pattern::quote).collect(Collectors.joining("|"));
	}
}
