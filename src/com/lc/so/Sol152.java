package com.lc.so;

import com.lc.pa.Lc152;

import java.util.Arrays;

/**
 * Created by lezh on 11/3/2016.
 */
public class Sol152 {
    public static void main(String[] args) {
        int[] a = {-3, -7};
        System.out.println(Arrays.toString(a) + " -> " + Lc152.maxProduct(a));

        int[] b = {3, 1, 2};
        System.out.println(Arrays.toString(b) + " -> " + Lc152.maxProduct(b));
    }
}
