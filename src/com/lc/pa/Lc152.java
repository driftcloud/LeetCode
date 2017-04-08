package com.lc.pa;

import java.util.Arrays;

/**
 * Created by lezh on 11/23/2016.
 */
public class Lc152 {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if (n<=0)
            return 0;

        int maxPosProd, maxNegProd;
        if (nums[0]>=0) {
            maxPosProd = nums[0];
            maxNegProd = 0;
        } else {
            maxPosProd = 0;
            maxNegProd = nums[0];
        }


        int maxSoFar = nums[0];
        for (int i=1; i<n; i++) {
            if (nums[i]>=0) {
                maxPosProd = Math.max(maxPosProd*nums[i], nums[i]);
                maxNegProd = maxNegProd*nums[i];
            } else {
                int prevmaxNegProd = maxNegProd;
                maxNegProd = Math.min(maxPosProd*nums[i], nums[i]);
                maxPosProd = prevmaxNegProd*nums[i];
            }
            maxSoFar = Math.max(maxSoFar, maxPosProd>0 ? maxPosProd : maxNegProd);
        }

        return maxSoFar;
    }

    public int maxProductOn2(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        int max = n==0 ? 0 : nums[0] ;

        for (int i=0; i<n; i++) {
            prod[i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                prod[j] = prod[j-1] * nums[j];
                max = Math.max(max, prod[j]);
            }
        }

        return max;
    }
}
