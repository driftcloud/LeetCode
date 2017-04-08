package com.lc.pa;

/**
 * Created by leizh on 10/31/2016.
 */
public class Lc338 {

    public static int[] countBits(int num) {

        if (num<0)
            return null;

        int[] bit_count = new int[num+1];

        if (num >= 0) {
            bit_count[0] = 0;
        }

        if (num >=1) {
            bit_count[1] = 1;
        }

        for (int i=2; i<num+1; i++) {
            if ((i & 1)==1) {
                bit_count[i] = bit_count[i-1] + 1;
            } else {
                bit_count[i] = bit_count[i/2];
            }
        }

        return bit_count;
    }
}
