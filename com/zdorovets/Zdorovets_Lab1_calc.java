package com.zdorovets;
class Zdorovets_Lab1_calc {
	
	public static int Add(String string) throws NumberFormatException,RuntimeException
	{	
		if(string.length()==0)
		{			
		    return 0;
		}
		else 
		{		
		    String[] numbers=string.split(",");
		    if(numbers.length==0)
    		    throw new RuntimeException("Error: invalid data.");
		    else if(numbers.length>2)
		    	throw new RuntimeException("Error: too many arguments.");
		    else if(numbers.length==1)
		    {
		    	return Integer.parseInt(numbers[0]);
		    }
		    else return Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
		    
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
