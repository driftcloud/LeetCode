package com.lc.pa;

import java.util.Arrays;

/**
 * Created by lezh on 11/30/2016.
 */
public class Lc361 {
    public static int maxKilledEnemies(char[][] grid) {

        int nrow = grid.length;
        int ncol = nrow == 0? 0 : grid[0].length;

        int[][] s = new int[nrow][ncol];
        char ch;
        int i, j, k, start, nkill;
        int res = 0;

        for (i=0; i<nrow; i++)
            Arrays.fill(s[i], 0);

        for (i=0; i<nrow; i++) {
            for (j = 0, start = 0, nkill = 0; j < ncol; j++) {
                ch = grid[i][j];
                switch (ch) {
                    case '0':
                        break;
                    case 'E':
                        nkill++;
                        s[i][j] = -1;
                        break;
                    case 'W':
                        for (k = start; k < j; k++)
                            if (s[i][k] >= 0) {
                                s[i][k] = nkill;
                            }
                        s[i][j] = -2;
                        nkill = 0;
                        start = j + 1;
                        break;
                }
            }

            for (k = start; k < ncol; k++)
                if (s[i][k] >= 0)
                    s[i][k] = nkill;
        }

        for (j=0; j<ncol; j++) {
            for (i = 0, start = 0, nkill = 0; i < nrow; i++) {
                ch = grid[i][j];
                switch (ch) {
                    case '0':
                        break;
                    case 'E':
                        nkill++;
                        break;
                    case 'W':
                        for (k = start; k < i; k++)
                            if (s[k][j] >= 0)
                                s[k][j] += nkill;
                        nkill = 0;
                        start = i + 1;
                        break;
                }
            }

            for (k = start; k < i; k++)
                if (s[k][j] >= 0)
                    s[k][j] += nkill;
        }

        for (i=0; i<nrow; i++)
            for (j = 0; j < ncol; j++)
                res = Math.max(res, s[i][j]);

        return res;
    }
}
