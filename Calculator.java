package lab1;

import java.util.regex.*;

public class Calculator {
	
	private String numbers (String str) {
		Pattern p = Pattern.compile("(//.*\n)*((.+))");
		Matcher m = p.matcher(str);
		if(m.find()) return (m.group(2));
		else return ("nonumbers");
	}
	
	private String delimiters (String str) {
		Pattern p = Pattern.compile("\\[([^\\]]*)\\]");
		Matcher m = p.matcher(str);
		if(m.find()) {
			String str1 = m.group(1);
			while (m.find()) str1 += "|"+m.group(1);
			return (str1);
		}
		else return (",|\n");
	}
	
	private void checkNegative(String str) throws ExceptionNegative {
		Pattern p = Pattern.compile("(-\\d+)");
		Matcher m = p.matcher(str);
		if(m.find()) {
			String str1 =  "negatives not allowed: "+m.group(1)+" ";
			while (m.find()) str1 += m.group(1)+" ";
			throw new ExceptionNegative(str1);
		}
	}
	
	public int add (String numbers) throws ExceptionNegative {
        int result = 0;
        checkNegative(numbers);
        String pNumbers = numbers (numbers);
        String pDelimiters = delimiters (numbers);
        if(pNumbers.equals("nonumbers")){
        	System.out.println("There're no numbers");
        	return result;
        }
        else{
	        for (String str : Pattern.compile(pDelimiters).split(pNumbers)) {
	        	int num = Integer.parseInt(str);
	            if (num < 1000)	result+=num;
	        }
        }
        return result;
    }
	
}
