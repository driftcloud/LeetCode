package com.lc.so;

import com.lc.pa.Lc154;

import java.util.Arrays;

/**
 * Created by lezh on 11/3/2016.
 */
public class Sol154 {
    public static void main(String[] args) {
        //int[] a = {3, 1};
        int[] a = {1, 2, 1};
        System.out.println(Arrays.toString(a) + " -> " + Lc154.findMin(a));

        int[] b = {11, 1, 1, 10, 10, 11};
        System.out.println(Arrays.toString(b) + " -> " + Lc154.findMin(b));
    }
}
