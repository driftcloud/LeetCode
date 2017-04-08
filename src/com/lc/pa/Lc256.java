package com.lc.pa;

/**
 * Created by lezh on 3/29/2017.
 */
public class Lc256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0)
            return 0;

        int[][] minSofar = new int[n][3];

        int i, j;
        for (j = 0; j < 3; j++)
            minSofar[0][j] = costs[0][j];

        for (i = 1; i < n; i++) {
            minSofar[i][0] = Math.min(minSofar[i - 1][1], minSofar[i - 1][2]) + costs[i][0];
            minSofar[i][1] = Math.min(minSofar[i - 1][0], minSofar[i - 1][2]) + costs[i][1];
            minSofar[i][2] = Math.min(minSofar[i - 1][0], minSofar[i - 1][1]) + costs[i][2];
        }

        int min = minSofar[n-1][0];
        for (j=1; j<3; j++)
            min = Math.min(min, minSofar[0][j]);

        return min;
    }
}
