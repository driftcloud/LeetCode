package com.lc.pa;

/**
 * Created by leizh on 8/28/2016.
 */
public class Lc066 {
    public static int[] plusOne(int[] src) {
        if (src == null)
            return null;

        int cnt9 = 0;
        for (int i : src) {
            if (i == 9) {
                cnt9++;
            }
        }

        int[] des;
        if (cnt9 == src.length)
            des = new int[src.length+1];
        else
            des = src;

        int i=src.length-1, j=des.length-1, car=1;
        for (int cur; i>=0; i--, j--) {
            cur = src[i] + car;
            if (cur >= 10) {
                cur = cur - 10;
                car = 1;
            } else {
                car = 0;
            }
            des[j] = cur;
        }

        if (j == 0) {
            assert(car == 1);
            des[j] = car;
        }

        return des;
    }
}
