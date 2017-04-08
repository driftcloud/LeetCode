package com.lc.so;

import com.lc.pa.Lc170;

import java.util.Arrays;

/**
 * Created by lezh on 11/26/2016.
 */
public class Sol170 {
    public static void main(String[] args) {
        Lc170 lc170 = new Lc170();
        int[] in = {0, 0, 1, 0};

        for (int x : in)
            lc170.twoSum.add(x);

        System.out.println("in = " + Arrays.toString(in));
        System.out.println("1 -> " + lc170.twoSum.find(1));
    }
}
