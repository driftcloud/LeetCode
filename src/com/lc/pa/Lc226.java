package com.lc.pa;

import com.lc.ds.TreeNode;

/**
 * Created by leizh on 10/29/2016.
 */
public class Lc226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode t;
        t = root.left;
        root.left = root.right;
        root.right = t;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
