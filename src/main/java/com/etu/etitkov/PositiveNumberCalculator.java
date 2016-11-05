package com.etu.etitkov;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lab #1
 * Simple sum calculator, which perform sum of number
 * separated by provided delimiters
 *
 * @author etitkov
 */
public class PositiveNumberCalculator {
    /*
     * Constants for regex patterns
     */
    private static final String DELIMITER_SEPARATOR = "\\[([^\\[\\]])*\\]";
    private static final String DEFAULT_DELIMITER_PATTERN = "//[(\\W*)]*\n";
    private static final String DEFAULT_DELIMITERS_REGEX = ",|\n";

    private static final Logger LOG = Logger.getLogger(PositiveNumberCalculator.class.getName());

    /**
     * @param inputData - an input string with a next format:
     *                  [${delim1}]${delim1}]\n12% where
     *                  [delim] - is a delimiter which separates
     *                  number from the rest of the string
     * @return - sum of numbers in the string
     * @throws NegativeValueException - if negative value provided
     */
    public int add(String inputData) throws NegativeValueException {
        String delimitersPart = getDelimitersPart(inputData);
        String numberPart = inputData.replace(delimitersPart, "");
        String delimiters = parseDelimiterPart(delimitersPart);
        int[] numbers = parseNumberPart(numberPart, delimiters);
        return sum(numbers);
    }

    /**
     * Parses number part of the string by splitting it with provided
     * delimiter regex.
     *
     * @param numbersPart - number part of the input string
     * @param delimiters - delimiters regex
     * @return - <code>int[] result</code> - result int array of numbers
     *
     * @throws NegativeValueException - if negative value provided
     */
    private int[] parseNumberPart(String numbersPart, String delimiters) throws NegativeValueException {
        //gets numbers with empty values
        String[] rawNumbers = numbersPart.split(delimiters);
        //filter empty values, maps them into int array
        int[] result = Arrays.stream(rawNumbers)
                .parallel()
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter((number) -> number < 1000)
                .toArray();
        long negativeCount = Arrays.stream(result)
                .parallel()
                .filter((number) -> number < 0)
                .count();
        if (negativeCount > 0) {
            throw new NegativeValueException("Negative Values are not allowed");
        }
        return result;
    }

    /**
     * Simple parallel sum method
     *
     * @param numbers - array of number to compute
     * @return - result value
     */
    private int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .parallel()
                .sum();
    }

    /**
     * Parses delimiter part by applying regex pattern
     * Concatenate all delimiters into result regex string
     *
     * @param delimiterPart - delimiter part of the input data
     * @return - delimiter regex with format : ?|%|$ ..etc
     */
    private String parseDelimiterPart(String delimiterPart) {
        StringBuilder builder = new StringBuilder();
        if (delimiterPart != null) {
            Pattern pattern = Pattern.compile(DELIMITER_SEPARATOR);
            Matcher matcher = pattern.matcher(delimiterPart);
            while (matcher.find()) {
                builder.append(matcher.group());
                builder.append('|');
            }
            builder.append(DEFAULT_DELIMITERS_REGEX);
        }
        return builder.toString().replaceAll("[\\[\\]]", "");
    }

    /**
     * Gets delimiter part of the string
     *
     * @param inputData - input data
     * @return - delimiter's part of the string
     */
    private String getDelimitersPart(String inputData) {
        Pattern pattern = Pattern.compile(DEFAULT_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(inputData);
        String delimiter = "";
        while (matcher.find()) {
            delimiter = matcher.group();
        }
        return delimiter;
    }


}
