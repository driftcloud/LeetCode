package com.lc.pa;

/**
 * Created by lezh on 12/30/2016.
 */
public class Lc122 {
    public int maxProfit(int[] prices) {
        int maxprof = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1])
                maxprof += prices[i] - prices[i-1];
        }
        return maxprof;
    }
}
