package com.lc.pa;

/**
 * Created by lezh on 12/31/2016.
 */
public class Lc084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0)
            return 0;

        int[][] minH= new int[n][n];
        int i, maxA = 0;
        for (i=0; i<n; i++) {
            minH[i][i] = heights[i];
            maxA = Math.max(maxA, heights[i]);
        }

        for (int d=1; d<n; d++)
            for (i=d; i<n; i++) {
                minH[i][i-d] = Math.min(minH[i-1][i-d], minH[i][i-d+1]);
                maxA = Math.max(maxA, minH[i][i-d]*(d+1));
            }

        return maxA;
    }
}
