package com.lc.pa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lezh on 11/6/2016.
 */
public class Lc078 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        genSubsets(nums, res, cur, 0);
        return res;
    }

    public static void genSubsets(int[] nums, List<List<Integer>> res, List<Integer> cur, int k) {

        if (k >= nums.length) {
            res.add(cur);
            return;
        }

        genSubsets(nums, res, cur, k+1);

        List<Integer> next = new ArrayList<>(cur);
        next.add(nums[k]);
        genSubsets(nums, res, next, k+1);
    }
}
