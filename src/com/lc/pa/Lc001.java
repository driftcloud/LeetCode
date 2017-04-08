package com.lc.pa;

import java.util.HashMap;

/**
 * Created by leizh on 10/27/2016.
 */
public class Lc001 {
    public static int[] twoSum(int[] nums, int target) {
        int i;

        HashMap<Integer, Integer> nhash = new HashMap<>();
        for (i=0; i<nums.length; i++)
            nhash.put(nums[i], i);

        for (i=0; i<nums.length; i++) {
            int st = target - nums[i];
            if ((nhash.containsKey(st))&&(nhash.get(st)!=i)) {
                int[] res = {i, nhash.get(st)};
                return res;
            }
        }

        return null;
    }
}
