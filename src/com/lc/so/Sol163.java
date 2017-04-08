package com.lc.so;

import com.lc.pa.Lc163;

import java.util.Arrays;

/**
 * Created by lezh on 11/6/2016.
 */
public class Sol163 {
    public static void main(String[] args) {

        //int[] nums = {0, 1, 3, 50, 75};
        //int[] nums = {-1};
        //int[] nums = {};
        //int[] nums = {2147483647};
        int[] nums = {-2147483648, 2147483647};
        System.out.println("nums = " + Arrays.toString(nums));

        //int lower = -2, upper = -1;
        //int lower = 1, upper = 1;
        //int lower = 0, upper = 2147483647;
        int lower = -2147483648, upper = 2147483647;
        System.out.format("%d ~ %d -> %s", lower, upper, Lc163.findMissingRanges(nums, lower, upper).toString());
    }
}
