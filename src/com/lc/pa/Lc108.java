package com.lc.pa;

import com.lc.ds.TreeNode;

/**
 * Created by lezh on 11/3/2016.
 */
public class Lc108 {

    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null)
            return null;

        return genTree(nums, 0, nums.length - 1);

    }

    public static TreeNode genTree(int[] nums, int low, int high) {

        if (low > high)
            return null;

        int mid = (low + high)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = genTree(nums, low, mid - 1);
        t.right = genTree(nums, mid + 1, high);
        return t;
    }
}
