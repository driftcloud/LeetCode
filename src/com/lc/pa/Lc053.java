package com.lc.pa;

/**
 * Created by lezh on 11/2/2016.
 */
public class Lc053 {
    public static int maxSubArray(int[] nums) {

        if ((nums==null) || (nums.length==0))
            return -1;

        int[] s = new int[nums.length];
        s[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            s[i] = Math.max(s[i-1] + nums[i], nums[i]);
        }

        int max = s[0];
        for (int i=1; i<nums.length; i++)
            max = max > s[i] ? max : s[i];

        return max;
    }
}
