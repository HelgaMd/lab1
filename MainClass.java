package com.iskandera.lab1;

/**
 * Created by zikovam on 27.10.16.
 */
public class MainClass {
    public static void main (String[] args) {
        Calc calc = new Calc ();

        String s = "4,5,6,2,3,4";

        try {
            System.out.println (calc.add (s));
        } catch (UnderTheZero underTheZero) {
            underTheZero.printStackTrace ();
        }
    }
}