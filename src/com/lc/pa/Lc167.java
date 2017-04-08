package com.lc.pa;

/**
 * Created by lezh on 11/8/2016.
 */
public class Lc167 {
    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i<numbers.length; i++) {
            int idx = bSearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if ( idx > 0) {
                int[] res = {i, idx};
                return res;
            }
        }

        return new int[0];
    }

    public static int bSearch(int[] numbers, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (numbers[mid] == target)
            return mid;
        else if (numbers[mid] > target)
            return bSearch(numbers, low, mid - 1, target);
        else
            return bSearch(numbers, mid + 1, high, target);
    }
}
