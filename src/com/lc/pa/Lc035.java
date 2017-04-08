package com.lc.pa;

/**
 * Created by lezh on 11/20/2016.
 */
public class Lc035 {
    public static int searchInsert(int[] nums, int target) {

        return insertLocation(nums, target, 0, nums.length - 1);
    }

    public static int insertLocation(int[] nums, int target, int lo, int hi) {
        if (lo >= hi)
            return target <= nums[lo] ? lo : lo + 1;

        int mid = (lo + hi) / 2;
        if (target == nums[mid])
            return mid;
        else if (target < nums[mid])
            return insertLocation(nums, target, lo, mid - 1);
        else
            return insertLocation(nums, target, mid + 1, hi);
    }
}
