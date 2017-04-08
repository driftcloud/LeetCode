package com.lc.so;

import com.lc.pa.Lc001;
import java.util.Arrays;

/**
 * Created by leizh on 10/27/2016.
 */
public class Sol001 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println("nums = " + Arrays.toString(nums));

        int[] res = Lc001.twoSum(nums, 6);
        System.out.println("res = " + Arrays.toString(res));
    }
}
