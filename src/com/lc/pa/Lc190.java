package com.lc.pa;

/**
 * Created by lezh on 11/7/2016.
 */
public class Lc190 {

    public static int reverseBits(int n) {

        int res = 0;
        for (int i=0; i<32; i++, n=n>>>1)
            res = (res<<1) | (n&1);
        return res;
    }
}
