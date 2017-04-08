package com.lc.pa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leizh on 10/29/2016.
 */
public class Lc163 {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {


        List<String> mr = new ArrayList<>();

        long prev, cur;
        int i;

        for (i=0, prev = lower-1; i<=nums.length; i++) {
            cur = i < nums.length ? nums[i] : upper + 1;

            if (cur - prev > 2)
                mr.add(String.format("%d->%d", prev + 1, cur - 1));
            else if (cur - prev == 2)
                mr.add(String.format("%d", cur - 1));

            prev = cur;

        }

        return mr;
    }
}
