package com.vittach;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by VITTACH on 05.10.2016
 * @author Zharikov Vitaliy- vk.com
 * @version 0.3.2
 */
public class Calculate {
    private int i= 2;
    private String input;
    private String agregateBuff = "";
    private String tokenSymbols = "";

    /**
     * for support changing a delimiter
     * @return
     */
    private boolean multiDelimiter() {
        while (true) {
            if (i + 1 < input.length()) {
                if (input.charAt(i)=='\n'
                        && input.charAt(i + 1) > '0'
                        && input.charAt(i + 1) < '9')
                    break;
            }
            else if(tokenSymbols.length()== 0)
                return false;
            else
                break;
            tokenSymbols += input.charAt(i++);
        }
        input = input.substring(i + 1);
        return true;
    }

    /**
     * basic method of simple String calculator
     * @param numbers
     * @return
     * @throws NegativeException
     */
    public int add(String numbers) throws NegativeException {
        int ceil;
        input = numbers;
        int agregate= 0;// result of this method
        boolean isNegative = false;
        ArrayList<Integer> negative = new ArrayList<>();

        if (input.length() > 0) {
            if (input.charAt(0) == '/'
                    && input.charAt(1) == '/') {
                if(!multiDelimiter())return 0;
            }
            else
                tokenSymbols = "\n,"; // set tokens by default

            StringTokenizer strTok;
            strTok = new StringTokenizer(input, tokenSymbols);
            int countOfToken;
            countOfToken=strTok.countTokens();

            while (strTok.hasMoreElements()) {
                String strTokEl=strTok.nextElement().toString();

                ceil=Integer.parseInt(strTokEl);
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
                    && agregateBuff.length() < input.length())
                return 0;

            if (isNegative)
                throw new NegativeException("Negatives not allowed: " + negative.toString());
        }
        return agregate;
    }
}
