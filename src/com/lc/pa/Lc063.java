package com.lc.pa;

/**
 * Created by lezh on 11/21/2016.
 */
public class Lc063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int nrow = obstacleGrid.length;
        int ncol = nrow > 0 ? obstacleGrid[0].length : 0;
        int[][] s = new int[nrow][ncol];

        for (int i=0; i<nrow; i++)
            for (int j=0; j<ncol; j++) {
                if (i==0) {
                    if (j==0)
                        s[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    else
                        s[i][j] = obstacleGrid[i][j] == 1 ? 0 : s[i][j - 1];
                } else if (j==0) {
                    s[i][j] = obstacleGrid[i][j] == 1 ? 0 : s[i-1][j];
                } else {
                    s[i][j] = obstacleGrid[i][j] == 1 ? 0 : s[i-1][j] + s[i][j-1];
                }
            }
        return (nrow==0) || (ncol==0) ? 0 : s[nrow-1][ncol-1];
    }
}
