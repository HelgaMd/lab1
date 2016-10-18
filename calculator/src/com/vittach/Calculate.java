package com.vittach;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by VITTACH on 05.10.2016.
 */
public class Calculate {
    public int Add(String fuckingCodacy) {
        int i= 2;
        int ceil;
        int agregate= 0;
        String agregateBuff = "";
        String tokenSymbols = "";
        boolean isNegative = false;
        ArrayList<Integer> negative = new ArrayList<>();

        if (fuckingCodacy.length() > 0) {
            if (fuckingCodacy.charAt(0) == '/'
                    && fuckingCodacy.charAt(1) == '/') {
                while (true) {
                    if (i + 1 < fuckingCodacy.length()) {
                        if (fuckingCodacy.charAt(i)=='\n'
                                && fuckingCodacy.charAt(i + 1) > '0'
                                && fuckingCodacy.charAt(i + 1) < '9')
                            break;
                    } else if(tokenSymbols.length()== 0)
                        return 0;
                    else
                        break;
                    tokenSymbols += fuckingCodacy.charAt(i++);
                }
                fuckingCodacy = fuckingCodacy.substring(i +1);
            }
            else
                tokenSymbols = "\n,";

            StringTokenizer strTok;
            strTok = new StringTokenizer(fuckingCodacy, tokenSymbols);
            int countOfToken;
            countOfToken=strTok.countTokens();

            while (strTok.hasMoreElements()) {
                String tokens=strTok.nextElement().toString();

                ceil = Integer.parseInt(tokens);
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
                    && agregateBuff.length() < fuckingCodacy.length())
                return 0;

            if (isNegative)
                throw new RuntimeException("Negatives not allowed: " + negative.toString());
        }
        return agregate;
    }
}
