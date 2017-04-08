package com.lc.pa;

import java.util.Arrays;

/**
 * Created by lezh on 11/6/2016.
 */
public class Lc060 {
    public static String getPermutation(int n, int k) {

        boolean[] taken = new boolean[n];
        Arrays.fill(taken, false);
        StringBuilder res = new StringBuilder();

        int factor = 1;
        for (int i=1; i<=n; i++)
            factor *= i;

        for (int i=0, rem=k-1, idx; i<n; i++) {
            factor /= n - i;
            idx = rem/factor;
            for (int j=0, cnt=0; j<n; j++) {
                if (taken[j])
                    continue;
                if (cnt>=idx) {
                    res.append(j+1);
                    taken[j] = true;
                    break;
                } else
                    cnt++;

            }

            rem %= factor;
        }

        return res.toString();
    }

}
