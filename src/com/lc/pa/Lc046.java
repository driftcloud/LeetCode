package com.lc.pa;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by lezh on 11/6/2016.
 */
public class Lc046 {
    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        genPerm(nums, cur, res, taken);
        return res;
    }

    public static void genPerm (int[] nums, List<Integer> cur, List<List<Integer>> res, boolean[] taken) {
        if (cur.size() >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!taken[i]) {
                taken[i] = true;
                cur.add(nums[i]);
                genPerm(nums, cur, res, taken);
                taken[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
