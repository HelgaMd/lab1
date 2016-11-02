package ru.labs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by nkurtushin on 02.11.16.
 */
public class ParseUtil {
    public static final String DELIMETERS_BEGIN = "//";
    public static final String DEFAULT_DELIMETER = ",";
    public static final String END_OF_THE_LINE = Character.toString('\n');
    /**
     *
     * @param delimeters
     * @return Список строк-разделителей
     */
    public static List<String> parseDelimeters(String delimeters) {
        List<String> delims = new ArrayList<>();
        Pattern regex = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = regex.matcher(delimeters);
        while (matcher.find()) {
            String delimeter = matcher.group(1);
            if(!delimeter.isEmpty()) {
                delims.add(delimeter);
            }
        }
        return delims;
    }


    public static String getRegExpForMultipleDelimeters(List<String> delimeters) {
        return delimeters.stream()
                .filter(s -> !s.isEmpty())
                .map(s -> String.format("(%s)", Pattern.quote(s)))
                .collect(joining("|")) + "|" + END_OF_THE_LINE;
    }

    //запретить случаи типа "1,\n"
    public static void checkDelimeterWithEndOfLine(String expression, List<String> delimeters) {
        Optional<String> nonValidToken = Stream.of(expression.split(END_OF_THE_LINE))
                .filter(line -> !line.isEmpty() && endsWithOrStartsWith(line, delimeters))
                .findAny();
        if(nonValidToken.isPresent()) {
            throw new IllegalStateException(String.format("Delimeters near end of line in not allowed '%s'",
                    nonValidToken.get()));
        }
    }

    public static boolean endsWithOrStartsWith(String line, List<String> delims) {
        return delims.stream()
                .filter(delim -> line.trim().endsWith(delim) || line.trim().startsWith(delim))
                .findAny()
                .isPresent();
    }
}
