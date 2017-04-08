package com.lc.so;

import com.lc.pa.Lc004;

import java.util.Arrays;

/**
 * Created by lezh on 11/2/2016.
 */
public class Sol004 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("median = " + Lc004.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2}, nums4 = {3, 4};
        System.out.println("nums3 = " + Arrays.toString(nums3));
        System.out.println("nums4 = " + Arrays.toString(nums4));
        System.out.println("median = " + Lc004.findMedianSortedArrays(nums3, nums4));
    }
}
