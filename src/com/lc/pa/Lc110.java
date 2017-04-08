package com.lc.pa;

import com.lc.ds.TreeNode;

import java.util.HashMap;

/**
 * Created by lezh on 11/2/2016.
 */
public class Lc110 {
    public static boolean isBalanced(TreeNode root) {

        HashMap<TreeNode, Integer> map = new HashMap<>();
        treeHeight(root, map);
        return chkBalance(root, map);
    }

    public static int treeHeight(TreeNode t, HashMap<TreeNode, Integer> map) {
        if (t==null)
            return 0;

        if (map.containsKey(t))
            return map.get(t);
        else {
            int tH = Math.max(treeHeight(t.left, map), treeHeight(t.right, map)) + 1;
            map.put(t, tH);
            return tH;
        }
    }

    public static boolean chkBalance(TreeNode t, HashMap<TreeNode, Integer> map) {
        if (t==null)
            return true;

        if (!chkBalance(t.left, map))
            return false;

        if (!chkBalance(t.right, map))
            return false;

        return Math.abs(treeHeight(t.left, map) - treeHeight(t.right, map)) < 2;
    }
}
