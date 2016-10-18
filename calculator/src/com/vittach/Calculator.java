package com.vittach;

/**
 * Created by VITTACH on 05.10.2016.
 */
public class Calculator {
    public static void main(String[] argv) {
        Calculate calc= new Calculate();

        System.out.println("Zharikov Vitaliy. Examples:");
        System.out.println("//;\\n,*\\n1;2,**4 = " + calc.Add("//;\n,*\n1;2,**4"));
        System.out.println("//;*\\n1;2***1000 = " + calc.Add("//;*\n1;2***1000"));
        try {
            calc.Add("1,-20,-3\n-14,7");
        } catch (RuntimeException e) {
            System.out.print(e.getMessage());
            System.out.println();
        }
        System.out.println("1,\\n = " + calc.Add("1,\n"));
        System.out.println("1\\n8 = " + calc.Add("1\n8"));
    }
}
