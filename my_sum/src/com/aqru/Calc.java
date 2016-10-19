package com.aqru;
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

class Calc {

    private void throwNegativeError(String numbers) throws SubZero{
        Matcher m = Pattern.compile("(-\\d+)").matcher(numbers);
        if (m.find()){
            String str =  "Negatives not allowed. "+m.group(1)+" ";
            while (m.find())
                str += m.group(1)+" ";
            throw new SubZero(str);
        }
    }

    private String getDelimiters(String numbers){
        // trying get delimiters
        Matcher m = Pattern.compile("\\[([^\\]]*)\\]").matcher(numbers);
        String delimiters = "";
        while (m.find())
            delimiters += m.group(1)+"|";
        return delimiters.isEmpty() ? ",|\n" : delimiters.substring(0, delimiters.length()-1);
    }

    private String getNumbers(String numbers){
        // get numbers
        Matcher m = Pattern.compile("//.*\\n(.*)").matcher(numbers);
        return (m.find()) ? m.group(1) : numbers;
    }

    public int add(String numbers) throws SubZero{
        // if empty str - return 0
        if (numbers.isEmpty()){
            return 0;
        }
        //checking on negative numbers...
        this.throwNegativeError(numbers);

        // trying get delimiters
        String delimiters = this.getDelimiters(numbers);
        // getting numbers
        String str_num = this.getNumbers(numbers);

        int result = 0;
        for (String s : Pattern.compile(delimiters).split(str_num)) {
            int i = Integer.parseInt(s);
            result += (i <= 1000) ? i : 0;
        }
        return result;
        }
}
