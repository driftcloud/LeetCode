package com.lc.pa;

import com.lc.ds.TreeNode;

import java.util.Stack;

/**
 * Created by lezh on 12/30/2016.
 */
public class Lc173 {
    public class BSTIterator {
        private Stack<TreeNode> iterSt;

        public BSTIterator(TreeNode root) {
            iterSt = new Stack<>();
            while (root != null) {
                iterSt.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !iterSt.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = iterSt.pop();
            TreeNode p = cur.right;
            while (p != null) {
                iterSt.push(p);
                p = p.left;
            }
            return cur.val;
        }
    }
}
