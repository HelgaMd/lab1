package com.etu.etitkov;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application start class
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PositiveNumberCalculator calc = new PositiveNumberCalculator();
        try {
            System.out.println(calc.add("//[;'][%][;][\n]\n123;;;;;;4%%%%3912\n%%%%%5;'1;9;7;11"));
        } catch (NegativeValueException e) {
            LOG.log(Level.SEVERE, "Negative values are not allowed", e);
        }
    }
}
