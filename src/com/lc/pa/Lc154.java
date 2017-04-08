package com.lc.pa;

/**
 * Created by lezh on 11/20/2016.
 */
public class Lc154 {
    public static int findMin(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        while ((lo < hi) && (nums[lo] >= nums[hi])) {
            while ((hi>lo) && (nums[lo] == nums[hi])) hi--;
            if (nums[lo] < nums[hi])
                break;
            int mid = (lo + hi) / 2;
            if (nums[mid] >= nums[lo] ) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
