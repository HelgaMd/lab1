/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_1_prom_prog;

/**
 *
 * @author Андрей
 */
public class Calculator {
    
    public int add(String num)
    {
        int result = 0;
        String arguments[];
        String delimiter = getDelimiter(num);
        int exit_cycle = 0;
        
        if(num.isEmpty())
        {
            return result;
        }
        arguments = num.split("\n")[1].split(delimiter);
        for(int i = 0; i < arguments.length && exit_cycle < 3; i++)
        {
            try
            {
                int number = Integer.parseInt(arguments[i]);
                if(number <= 1000)
                    result = result + number;
                exit_cycle++;
            }
            catch (NumberFormatException e)
            {
                //System.out.print("Uncorrect argument\n");
                String[] res = arguments[i].split("\n");
                result = Integer.parseInt(res[0]) + Integer.parseInt(res[1]);
            }
        }
        
        return result;
    }
    
    int checkNewString(String in)
    {
       int result = 0;
       //System.out.print(in);
       if(in.contains("\n"))
       {
           String arg[] = in.split(in);
           result = Integer.parseInt(arg[0]) + Integer.parseInt(arg[1]);        
       }
       
       return result;
    }
    
    String getDelimiter(String in)
    {
        String result = ",";
        
        String temp_in = in.split("\n")[0];
        
        if(temp_in.startsWith("//[") & temp_in.endsWith("]"))
            result = temp_in.substring(3, temp_in.length() - 1);
        
        return result;
    }
    
}
