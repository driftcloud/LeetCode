package com.lc.pa;

import com.lc.ds.TreeNode;

/**
 * Created by lezh on 12/19/2016.
 */
public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else
            return isSubTreeSym(root.left, root.right);
    }

    public boolean isSubTreeSym(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;

        if (left.val == right.val)
            return isSubTreeSym(left.left, right.right) && isSubTreeSym(left.right, right.left);
        else
            return false;
    }
}
