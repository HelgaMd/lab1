import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by VITTACH on 05.10.2016.
 */
public class calculate {
    public int Add(String numbers) {
        String agregateBuff = "";
        String tokenSymbols = "";
        boolean isNegative = false;
        int agregate= 0,i= 2, ceil;
        ArrayList<Integer> negative=new ArrayList<>();

        if (numbers.length() > 0) {
            if (numbers.charAt(0) == '/'
                    && numbers.charAt(1) == '/') {
                while (true) {
                    if (i + 1 < numbers.length()) {
                        if (numbers.charAt(i)=='\n'
                                && numbers.charAt(i + 1) > '0'
                                && numbers.charAt(i + 1) < '9')
                            break;
                    } else if(tokenSymbols.length()== 0)
                        return 0;
                    else
                        break;
                    tokenSymbols += numbers.charAt(i++);
                }
                numbers = numbers.substring(i + 1);
            }
            else
                tokenSymbols = "\n,";

            StringTokenizer strTok;
            strTok = new StringTokenizer(numbers, tokenSymbols);
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
                    && agregateBuff.length() < numbers.length())
                return 0;

            if (isNegative) {
                System.out.print("negatives not allowed: ");
                for(int ceils:negative)
                    System.out.print(ceils+".");
                System.out.println();
                return 0;
            }
        }
        return agregate;
    }
}
