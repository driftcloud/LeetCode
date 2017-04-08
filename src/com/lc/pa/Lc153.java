package com.lc.pa;

/**
 * Created by lezh on 11/3/2016.
 */
public class Lc153 {

    public static int findMin(int[] nums) {

        int lo = 0, hi = nums.length - 1;

        while ((lo < hi) && (nums[lo] > nums[hi])) {
            int mid = (lo + hi) / 2;
            if ((nums[mid] >= nums[lo]))
                lo = mid + 1;
            else
                hi = mid;
        }

        return nums[lo];
    }
}
