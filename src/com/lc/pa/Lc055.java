package com.lc.pa;

import java.util.Arrays;

/**
 * Created by lezh on 12/26/2016.
 */
public class Lc055 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return false;

        boolean[] s = new boolean[n];
        s[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j>=0 && !s[i]; j--)
                if (s[j] && j+nums[j]>=i )
                    s[i]=true;
        }

        return s[n-1];
    }
}
