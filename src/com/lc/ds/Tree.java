package com.lc.ds;

import com.lc.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leizh on 10/29/2016.
 */
public class Tree {
    public TreeNode root;
    public Tree(String[] st) throws Exception {
        if (st == null) {
            throw new NullPointerException("null input!");
        }

        int n = st.length;
        Integer[] aI = new Integer[n];
        for (int i=0; i<n; i++) {
            aI[i] = st[i].equals("#") ? null : Integer.parseInt(st[i]);
        }
        treeInit(aI);
    }

    public Tree(Integer[] aI) throws Exception {
        if (aI == null) {
            throw new NullPointerException("null input!");
        }

        treeInit(aI);
    }

    public void treeInit(Integer[] aInt) throws IllegalArgumentException {

        if (aInt.length < 1)
            return;

        Queue<TreeNode> levelq = new LinkedList<>();
        root = new TreeNode(aInt[0]);
        levelq.add(root);
        TreeNode cur = null, t = null;
        for (int i=1; i<aInt.length; i++) {
            if (aInt[i] == null)
                t = null;
            else {
                t = new TreeNode(aInt[i]);
                levelq.add(t);
            }

            if ((i&1) == 1) {
                if (levelq.isEmpty())
                    throw new IllegalArgumentException("Leveq Empty!");
                cur = levelq.poll();

                cur.left = t;
            } else
                cur.right = t;

        }
    }

    public void dump() {
        if (root == null)
            System.out.println("#");

        Queue<TreeNode> levelq = new LinkedList<>();
        levelq.add(root);
        while(!levelq.isEmpty()) {
            TreeNode t;
            t = levelq.remove();
            if (t == null)
                System.out.print("#, ");
            else {
                System.out.format("%d, ", t.val);
                levelq.add(t.left);
                levelq.add(t.right);
            }
        }
    }
}
