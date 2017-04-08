package com.lc.pa;

/**
 * Created by lezh on 12/25/2016.
 */
public class Lc300 {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length, lis = 1, maxSofar;
        if (n < 1)
            return 0;

        int[] s = new int[n];
        s[0] = 1;

        for (int i = 1; i < n; i++) {
            maxSofar = 1;
            for (int j = 0; j < i; j++) {
                if ( nums[i] > nums[j])
                    maxSofar = Math.max(maxSofar, s[j] + 1);
            }
            s[i] = maxSofar;
            lis = Math.max(lis, maxSofar);
        }

        return lis;
    }
}
