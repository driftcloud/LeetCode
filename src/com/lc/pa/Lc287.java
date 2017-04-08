package com.lc.pa;

/**
 * Created by lezh on 3/30/2017.
 */
public class Lc287 {
    public int findDuplicate(int[] nums) {

        int n = nums.length - 1;
        int low = 1, high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            int nlow, i;
            for (nlow = 0, i = 0; i < n + 1; i++)
                if (nums[i] >= low && nums[i] <= mid)
                    nlow++;

            if (nlow > mid - low + 1)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
