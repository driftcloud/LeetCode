package com.lc.so;

import com.lc.pa.Lc046;
import java.util.Arrays;

/**
 * Created by lezh on 11/6/2016.
 */
public class Sol046 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("res = " + Lc046.permute(nums).toString());
    }
}
