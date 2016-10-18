package com.zdorovets; 
import java.util.ArrayList;
class NegativeException extends Exception
{
	private static final long serialVersionUID = 1L;
	public NegativeException(String message)
	{
		super(message);
	}
}
class Zdorovets_Lab1_calc {
	
	public static int add(String input_string) throws NumberFormatException, NegativeException
	{
	String input=input_string;
	String delimiter=",|\n";
	String numbersWithoutDelimiter=input;
	if(input.startsWith("//["))
	    delimiter="";
	int delimiterIndex,
        i,
        l;
	while (input.startsWith("//[")) {
        delimiterIndex=input.indexOf("//")+3;
        i=delimiterIndex;
        l=0;
        if(!"".equals(delimiter))
        	delimiter=delimiter+"|";
        while(!input.substring(i,i+1).equals("]"))
        {
        	delimiter=delimiter+input.substring(i,i+1);
        	i++;
        	l++;
        }  
        input=input.substring(delimiterIndex+l+1);        
        if(input.startsWith("["))
        {
        	input="//"+input;        	
        }
        else numbersWithoutDelimiter=input.substring(input.indexOf("\n")+1);
	}
        
	if (input.startsWith("//")) {
        int delimIndex=input.indexOf("//")+2;
        delimiter=input.substring(delimIndex,delimIndex+1);
        numbersWithoutDelimiter=input.substring(input.indexOf("\n")+1);
    }
    return add(numbersWithoutDelimiter, delimiter);
	}
	 
	public static int add(String input,String delimiter) throws NumberFormatException,NegativeException
	{			
			int sum=0; 
		    String[] numbers=input.split(delimiter);
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
		        throw new NegativeException("Negatives not allowed: " + negativeList.toString());
		    }
		    return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
