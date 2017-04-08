package com.lc.pa;

/**
 * Created by lezh on 11/2/2016.
 */
public class Lc062 {

    public static int uniquePaths(int m, int n) {

        if ((m<=0)||(n<=0))
            return 0;

        int[][] s = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++)
                if ((i == 0) || (j == 0))
                    s[i][j] = 1;
                else
                    s[i][j] = s[i - 1][j] + s[i][j - 1];
        }

        return s[m-1][n-1];
    }
}
