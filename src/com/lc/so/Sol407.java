package com.lc.so;

import com.lc.pa.Lc066;

import java.util.Arrays;

/**
 * Created by leizh on 10/27/2016.
 */
public class Sol407 {
    // com.lc.pa.Lc066
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] res = Lc066.plusOne(a);
        System.out.println("res = " + Arrays.toString(res));

        int[] b = {9, 9, 9};
        res = Lc066.plusOne(b);
        System.out.println("res = " + Arrays.toString(res));
    }
}
