package ru.labs;

import static ru.labs.Calculator.*;
import static ru.labs.Calculator.add;

/**
 * Created by Денис on 01.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(add("//[first][second][third]\n3first4second5\n14third11"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
