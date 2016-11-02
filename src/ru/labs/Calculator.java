package ru.labs; /**
 * Created by Денис on 18.10.2016.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static ru.labs.util.ParseUtil.*;

public class Calculator {
    public static final int MAX_NUMBER = 1000;

    public static int add(String numbers) {
        if(numbers == null) {
            throw new IllegalArgumentException("Numbers can not be null");
        }
        if(numbers.isEmpty()) {
            return 0;
        }
        if(numbers.startsWith(DELIMETERS_BEGIN)) {
            String delimStr = numbers.substring(DELIMETERS_BEGIN.length(), numbers.indexOf(END_OF_THE_LINE));
            String calc = numbers.substring(numbers.indexOf(delimStr) + delimStr.length());
            //костыль для проверки много разделителей или один кастомный
            if(!delimStr.matches("\\[(.*?)\\]")) {
                return add(Arrays.asList(END_OF_THE_LINE, delimStr), calc);
            }
            return add(parseDelimeters(delimStr), calc);
        }
        return add(Arrays.asList(END_OF_THE_LINE, DEFAULT_DELIMETER), numbers);
    }

    private static int add(List<String> delimeters, String numbers) {
        checkDelimeterWithEndOfLine(numbers, delimeters);
        return Stream.of(numbers.split(getRegExpForMultipleDelimeters(delimeters)))
                .filter(num -> !num.trim().isEmpty())
                .mapToInt(num -> {
                    int number = Integer.parseInt(num.trim());
                    return number > MAX_NUMBER ? 0 : number;
                })
                .sum();
    }
}