package com.yanaguseva.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private int MAX_VAL = 1000;
    private String defaultDelimiters = ",|;|\n";
    private Pattern pattern = Pattern.compile("^//(.+)\\n(.*)$");
    private Pattern pDelimiter = Pattern.compile("\\[([^\\]]+)\\]");
    private String NEGATIVES_NOT_ALLOWED = "negatives not allowed ";

    public int add(String string) {
        if (string.length() == 0) {
            return 0;
        }
        String[] values = getValues(string);
        try {
            checkNegatives(values);
        } catch (NegativeNumbersException e) {
            System.out.println(e.getMessage());
        }
        return sum(values);
    }

    private String[] getValues(String string) {
        return getNumbersString(string).split(getDelimeters(string));
    }

    private String getDelimeters(String string) {
        Matcher m = pattern.matcher(string);
        if (!m.matches()) {
            return defaultDelimiters;
        }
        String delimString = m.group(1);
        Matcher mDelim = pDelimiter.matcher(delimString);
        String delimiters = "";
        while (mDelim.find()) {
            delimiters += (Pattern.quote(mDelim.group(1)) + "|");
        }
        return delimiters.substring(0, delimiters.length()-1);
    }

    private String getNumbersString(String string) {
        Matcher m = pattern.matcher(string);
        if (!m.matches()) {
            return string;
        }
        return m.group(2);
    }

    private int sum(String values[]) {
        int sum = 0;
        for (String value : values) {
            int number = parseVal(value);
            if (number < MAX_VAL)
                sum += number;
        }
        return sum;
    }

    private int parseVal(String value) {
        return Integer.valueOf(value);
    }

    private void checkNegatives(String[] values) throws NegativeNumbersException {
        String negatives = "";
        for (String value : values) {
            if (parseVal(value) < 0) {
                negatives += "," + value;
            }
        }
        if (negatives.length() > 0) {
            throw new NegativeNumbersException(NEGATIVES_NOT_ALLOWED + negatives.substring(1));
        }
    }
}

