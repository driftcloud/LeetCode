package com.lc.pa;

/**
 * Created by leizh on 10/30/2016.
 */
public class Lc121 {

    public static int maxProfit(int[] prices) {

        if (prices==null)
            return 0;

        int[][] v = new int[2][prices.length];
        int j;

        for (j=1; j<prices.length; j++) {
            v[0][j] = Math.max(0, v[0][j-1] + prices[j]-prices[j-1]);
        }

        for (j=1; j<prices.length; j++) {
            v[1][j] = Math.max(v[1][j-1], v[0][j]);
        }

        return v[1][prices.length-1];
    }
}
