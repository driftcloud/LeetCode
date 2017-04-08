package com.lc.pa;

/**
 * Created by lezh on 11/2/2016.
 */
public class Lc004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1==null) || (nums2==null))
            return 0;

        int i = 0, j = 0, m = 0, n = 0, tl = nums1.length + nums2.length + 1;

        if (tl==0)
            return 0;

        for (int k = 0; k < tl/2; k++ ) {
            if (i>nums1.length-1)
                m = nums2[j++];
            else if (j>nums2.length-1)
                m = nums1[i++];
            else if (nums1[i] < nums2[j])
                m = nums1[i++];
            else
                m = nums2[j++];
        }

        if ((tl&1)==1) {
            if (i>nums1.length-1)
                n = nums2[j++];
            else if (j>nums2.length-1)
                n = nums1[i++];
            else if (nums1[i] < nums2[j])
                n = nums1[i++];
            else
                n = nums2[j++];
            return ((double)m + (double)n)/2;
        } else
            return (double)m;
    }
}
