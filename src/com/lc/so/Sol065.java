package com.lc.so;

import com.lc.pa.Lc065;

/**
 * Created by lezh on 11/5/2016.
 */
public class Sol065 {
    public static void main(String[] args) {
        String a = "e9";
        System.out.println(a + " -> " + Lc065.isNumber(a));

        String b = ".e1";
        System.out.println(b + " -> " + Lc065.isNumber(b));

        String c = ".2e81";
        System.out.println(c + " -> " + Lc065.isNumber(c));
    }
}
