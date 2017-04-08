package com.lc.pa;

/**
 * Created by lezh on 12/26/2016.
 */
public class Lc026 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int idup = 1, inod = 0;
        for (; idup < nums.length; idup++)
            if (nums[idup] != nums[idup - 1]) {
                nums[++inod] = nums[idup];
            }
        return inod + 1;
    }
}
