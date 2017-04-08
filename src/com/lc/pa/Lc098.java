package com.lc.pa;

import com.lc.ds.TreeNode;

/**
 * Created by lezh on 11/1/2016.
 */
public class Lc098 {

    public static boolean isValidBST(TreeNode root) {

        if (root==null)
            return true;

        if (!isValidBST(root.left))
            return false;

        if (!isValidBST(root.right))
            return false;

        boolean resr, resl;
        TreeNode t=root.left;
        if (t!=null) {
            while (t.right!=null)
                t=t.right;
            resl = t.val < root.val;
        } else {
            resl = true;
        }

        t=root.right;
        if (t!=null) {
            while (t.left!=null)
                t=t.left;
            resr = t.val > root.val;
        } else {
            resr = true;
        }

        return resl&&resr;

    }
}
