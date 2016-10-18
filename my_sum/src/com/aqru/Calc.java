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

    private void throw_negative_error(String numbers) throws SubZero{
        Matcher m = Pattern.compile("(-\\d+)").matcher(numbers);
        if (m.find()){
            String str =  "Negatives not allowed. "+m.group(1)+" ";
            while (m.find())
                str += m.group(1)+" ";
            throw new SubZero(str);
        }
    }

    public int add(String numbers) throws SubZero{
        // if empty str - return 0
        if (numbers.isEmpty()){
            return 0;
        }
//        // if we have negative numbers...
//        Matcher m = Pattern.compile("(-\\d+)").matcher(numbers);
//        if (m.find()){
//            String str =  "Negatives not allowed. "+m.group(1)+" ";
//            while (m.find())
//                str += m.group(1)+" ";
//            throw new SubZero(str);
//        }

        //checking on negative numbers...
        this.throw_negative_error(numbers);

        // trying get delimiters
        Matcher m = Pattern.compile("\\[([^\\]]*)\\]").matcher(numbers);
        String delimiters = "";
        while (m.find())
            delimiters += m.group(1)+"|";
        delimiters = delimiters.isEmpty() ? ",|\n" : delimiters.substring(0, delimiters.length()-1);
        String str_num = ((m = Pattern.compile("//.*\\n(.*)").matcher(numbers)).find()) ? m.group(1) : numbers;

        int result = 0;
        for (String s : Pattern.compile(delimiters).split(str_num)) {
            int i = Integer.parseInt(s);
            result += (i <= 1000) ? i : 0;
        }
        return result;
        }
}
