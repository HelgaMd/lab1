package com.aqru;

/**
 * Created by Aqru on 04.10.16.
 *
 */
public class My_sum {

    public static void main(String[] args) {
        Calc c = new Calc();
        try {
            int r = c.add("1\n1,3,3\n1001");
            System.out.println(r);
        }
        catch (SubZero e){
            e.printStackTrace();
        }
    }
}
