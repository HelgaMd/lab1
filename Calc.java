package com.iskandera.lab1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iskandera on 27.10.16.
 */

class UnderTheZero extends Exception {
    UnderTheZero (String msg){
        super(msg);
    }
}

public class Calc {

    //checking negative numbers
    private void checkNegativeNumber(String numbers) throws UnderTheZero{
        Pattern p = Pattern.compile("(-\\d+)");
        Matcher m = p.matcher(numbers);
        if (m.find()){
            String str =  "negatives not allowed"+m.group(1)+" ";
            while (m.find())
                str += m.group(1)+" ";
            throw new UnderTheZero (str);
        }
    }

    //let's get some numbers, baby
    private String numbersParser (String numbers) {
        Pattern p = Pattern.compile ("//.*\\n(.*)");
        Matcher m = p.matcher (numbers);

        if (m.find ())
            return (m.group (1));
        else
            return (numbers);
    }

    //and delimiters too
    private String delimitersParser (String numbers) {
        Pattern p = Pattern.compile ("\\[([^\\]]*)\\]");
        Matcher m = p.matcher (numbers);
        StringBuilder delimiters = new StringBuilder ();
        while (m.find ()) {
            delimiters.append (m.group (1));
            delimiters.append ("|");
        }
        if (delimiters.length () == 0)
            return (",|\n");
        else
            return delimiters.substring (0, delimiters.length () - 1);
    }

    //calc numbers
    public int add (String numbers) throws UnderTheZero{
        //create int for our result
        int result = 0;

        //empty String - return 0
        if (numbers.isEmpty ()){
            return result;
        }
        //are there negative numbers
        this.checkNegativeNumber (numbers);

        //let's chek our delimiter and numbers
        String delimiter = delimitersParser (numbers);
        String numbersOnly = numbersParser (numbers);

        for (String num :
                Pattern.compile (delimiter).split (numbersOnly)) {
            if (Integer.parseInt (num) < 1000)
                result+=Integer.parseInt (num);
        }
        return result;
    }
}
