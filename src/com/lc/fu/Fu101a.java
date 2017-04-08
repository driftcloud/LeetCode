package com.lc.fu;

import com.lc.ds.TreeNode;

/**
 * Created by lezh on 3/30/2017.
 * Follow up question: Generate a new tree which is an mirror image of existing tree
 */
public class Fu101a {
    public TreeNode createSymmetric(TreeNode root) {
        if (root == null)
            return null;

        TreeNode symroot = new TreeNode(root.val);
        symroot.right = createSymmetric(root.left);
        symroot.left = createSymmetric(root.right);

        return symroot;
    }

}
