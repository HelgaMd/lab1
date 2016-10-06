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
		    String[] numbers=string.split(",|\n");
		    if(numbers.length==0)
    		    throw new RuntimeException("Error: invalid data.");
		    else 
		    {
		    	int sum=0;
		    	for(int i=0; i<numbers.length; i++)
		    		sum+=Integer.parseInt(numbers[i]);
		    	return sum;
		    }
		    
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
