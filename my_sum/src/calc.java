import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aqru on 04.10.16.
 * lab1 by Kadriev Ruslan
 */

class SubZero extends Exception {
    SubZero(String msg){
        super(msg);
    }
}

class calc {

    private String get_sub_zero(String[] numbers){
        String msg = "Negatives not allowed. ";
        for (String s: numbers) {
            if (Integer.parseInt(s) < 0) {
                msg = msg + "[" + s + "] ";
            }
        }
        return msg;
    }

    private int def_add(String numbers, String delimiters){
        int result = 0;
        Pattern pattern = Pattern.compile(delimiters);
        String[] str_numbers = pattern.split(numbers);

        for (String number : Arrays.asList(str_numbers)) {
            int temp = Integer.parseInt(number);
            // cut all int > 1000;
            if (temp <= 1000) {
                // throw subzero int exception;
                if (temp < 0) {
                    try {
                        throw new SubZero(this.get_sub_zero(str_numbers));
                    }
                    catch (SubZero e){
                        e.printStackTrace();
                        return -1;
                    }
                }
                result += Integer.parseInt(number);
            }
        }
        return result;
    }

    int add(String numbers) {
        // if empty str - return 0
        if (numbers.isEmpty()){
            return 0;
        }

        // Set-up pattern
        Pattern pattern = Pattern.compile("\n");
        String[] str_numbers = pattern.split(numbers);
        // Check delimiters;
        if (str_numbers.length > 1) {
            pattern = Pattern.compile("^//(.*)");
            Matcher m = pattern.matcher(str_numbers[0]);
            if (m.matches()){
                pattern = Pattern.compile("\\[|\\]");
                String delimiters = "";
                for (String s:pattern.split(m.group(1))){
                    if (!s.isEmpty()) {
                        if (!delimiters.isEmpty())
                            delimiters = delimiters+"|"+s;
                        else
                            delimiters = delimiters+s;
                    }
                }
                return this.def_add(str_numbers[1], delimiters);
            }
            else {
                // If this is just /n delimiter;
                return this.def_add(numbers, ",|\n");
            }
        }
        else {
            // If we haven't custom delimiters;
            return this.def_add(numbers, ",|\n");
        }
    }
}
