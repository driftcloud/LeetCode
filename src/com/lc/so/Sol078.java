package com.lc.so;

import com.lc.pa.Lc078;

import java.util.Arrays;

/**
 * Created by lezh on 11/6/2016.
 */
public class Sol078 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("nums = " + Arrays.toString(nums));

        System.out.println("res = " + Lc078.subsets(nums).toString());
    }
}
