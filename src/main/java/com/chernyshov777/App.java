package com.chernyshov777;

/**
 * Entry point
 *@author Chernyshov Daniil
 */
public class App {
    public static void main( String[] args ) {
        String inputString = "//[;'][%][\n]\n123;3%6112\n%2;'3\n4";
        Calculator calculator = new Calculator();
        int result = calculator.add(inputString);
        System.out.println("Result = " + result);
    }
}
