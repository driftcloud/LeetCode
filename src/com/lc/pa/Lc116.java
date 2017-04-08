package com.lc.pa;

import com.lc.ds.TreeLinkNode;

/**
 * Created by lezh on 11/3/2016.
 */
public class Lc116 {
    public static void connect(TreeLinkNode root) {
        levelTraverse(root, null);
    }

    public static void levelTraverse(TreeLinkNode root, TreeLinkNode next) {

        if (root == null)
            return;

        levelTraverse(root.left, root.right);
        root.next = next;

        if (next == null)
            levelTraverse(root.right, null);
        else
            levelTraverse(root.right, next.left);
    }
}
