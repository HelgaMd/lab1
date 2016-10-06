package com.zdorovets; 
import java.util.ArrayList;
 
class Zdorovets_Lab1_calc {
	public static int Add(String string)
	{
	String delimiter=",|\n";
	String numbersWithoutDelimiter=string;	
	if (string.startsWith("//")) {
        int delimiterIndex=string.indexOf("//")+2;
        delimiter=string.substring(delimiterIndex,delimiterIndex+1);
        numbersWithoutDelimiter=string.substring(string.indexOf("\n")+1);
    }
    return Add(numbersWithoutDelimiter, delimiter);
	}
	
	public static int Add(String string,String delimiter) throws NumberFormatException,RuntimeException
	{			
			int sum=0; 
		    String[] numbers=string.split(delimiter);
		    ArrayList<Integer> negativeList=new ArrayList<Integer>();
		    int num;
		    for (String number : numbers) {
		        if (!number.trim().isEmpty()) {
		        	num=Integer.parseInt(number.trim());
		        	if (num < 0)
		        		negativeList.add(num);
		        	else if(num<=1000)
		        		sum += num;
		        }
		    }  
		    if (negativeList.size() > 0) {
		        throw new RuntimeException("Negatives not allowed: " + negativeList.toString());
		    }
		    return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
