package com.lc.so;

import java.util.Arrays;
import com.lc.pa.Lc361;

/**
 * Created by lezh on 12/12/2016.
 */
public class Sol361 {
    public static void main(String[] args) {
        String[] in = {"WWWWW","WEEEW", "WE0EW","WEEEW","WWWWW"};
        int nrow = in.length, ncol = in[0].length();
        char[][] grid = new char[nrow][ncol];
        int i;
        for (i=0; i<nrow; i++)
            for (int j=0; j<ncol; j++)
                grid[i][j] = in[i].charAt(j);

        for (i=0; i<nrow; i++)
            System.out.println(Arrays.toString(grid[i]));

        System.out.println("-> " + Lc361.maxKilledEnemies(grid));
    }
}
