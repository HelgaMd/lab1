package com.zdorovets;
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
		    for (String number : numbers) {
		        if (!number.trim().isEmpty()) {
		            sum += Integer.parseInt(number.trim());
		        }
		    }
		    return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
