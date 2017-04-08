package com.lc.pa;

/**
 * Created by lezh on 11/25/2016.
 */
public class Lc136 {
    public int singleNumber(int[] nums) {

        int totalXor = 0;
        for (int i=0; i<nums.length; i++)
            totalXor ^= nums[i];

        return totalXor;

    }
}
