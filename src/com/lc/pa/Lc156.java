package com.lc.pa;

import com.lc.ds.TreeNode;
/**
 * Created by lezh on 11/10/2016.
 */
public class Lc156 {

    /*  Postorder traversal will yield preorder traversal for UDTree
    *
    * */
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null)
            return null;

        if (root.left == null)
            return root;

        TreeNode new_root = upsideDownBinaryTree(root.left), t=new_root;
        while (t.right!=null)
            t=t.right;

        t.left = upsideDownBinaryTree(root.right);
        root.left = root.right = null;
        t.right = root;

        return new_root;
    }
}
