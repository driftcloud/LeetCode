package com.lc.pa;

/**
 * Created by leizh on 10/30/2016.
 */
public class Lc070 {

    public static int climbStairs(int n) {

        if (n<0)
            return 0;

        if (n<=1)
            return 1;

        int res = 0;
        for (int i = 2, prev = 1, prevprev = 1; i <= n; i++) {
            res = prev + prevprev;
            prevprev = prev;
            prev = res;
        }

        return res;
    }
}
