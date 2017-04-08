package com.lc.so;

import com.lc.pa.Lc153;

import java.util.Arrays;

/**
 * Created by lezh on 11/3/2016.
 */
public class Sol153 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 4, 5, 6, 7};
        System.out.println(Arrays.toString(a) + " -> " + Lc153.findMin(a));

        int[] b = {3, 1, 2};
        System.out.println(Arrays.toString(b) + " -> " + Lc153.findMin(b));
    }
}
