package com.vittach;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by VITTACH on 05.10.2016.
 */
class NegativeException extends Exception
{
    private static final long serialVersionUID = 1L;
    public NegativeException(String message) {
        super(message);
    }
}

public class Calculate {
    public int add(String inputs) throws NegativeException {
        int i= 2;
        int ceil;
        int agregate= 0;
        String element = inputs;
        String agregateBuff = "";
        String tokenSymbols = "";
        boolean isNegative = false;
        ArrayList<Integer> negative = new ArrayList<>();

        if (element.length() > 0) {
            if (element.charAt(0) == '/'
                    && element.charAt(1) == '/') {
                while (true) {
                    if (i + 1 < element.length()) {
                        if (element.charAt(i)=='\n'
                                && element.charAt(i + 1) > '0'
                                && element.charAt(i + 1) < '9')
                            break;
                    } else if(tokenSymbols.length()== 0)
                        return 0;
                    else
                        break;
                    tokenSymbols += element.charAt(i++);
                }
                element = element.substring(i + 1);
            }
            else
                tokenSymbols = "\n,";

            StringTokenizer strTok;
            strTok = new StringTokenizer(element, tokenSymbols);
            int countOfToken;
            countOfToken=strTok.countTokens();

            while (strTok.hasMoreElements()) {
                String strTokEl=strTok.nextElement().toString();

                ceil = Integer.parseInt(strTokEl);
                if (ceil < 0) {
                    negative.add(ceil);
                    isNegative= true;
                }
                else if(ceil <= 1000) {
                    agregateBuff+=ceil;
                    agregate += ceil;
                }
            }

            if (countOfToken == 1
                    && agregateBuff.length() < element.length())
                return 0;

            if (isNegative)
                throw new NegativeException("Negatives not allowed: " + negative.toString());
        }
        return agregate;
    }
}
