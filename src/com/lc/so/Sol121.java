package com.lc.so;

import com.lc.pa.Lc121;

import java.util.Arrays;

/**
 * Created by leizh on 10/30/2016.
 */
public class Sol121 {

    public static void main(String[] args) {
        int[] p = {7, 1, 5, 3, 6, 4};
        System.out.println("prices = " + Arrays.toString(p));
        System.out.println("MaxProfit = " + Lc121.maxProfit(p));

        int[] q = {7, 6, 5, 4, 3, 2};
        System.out.println("prices = " + Arrays.toString(q));
        System.out.println("MaxProfit = " + Lc121.maxProfit(q));

        int[] a = {7};
        System.out.println("prices = " + Arrays.toString(a));
        System.out.println("MaxProfit = " + Lc121.maxProfit(a));
    }
}
