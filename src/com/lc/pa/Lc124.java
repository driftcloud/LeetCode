package com.lc.pa;

import com.lc.ds.TreeNode;

/**
 * Created by lezh on 11/26/2016.
 */
public class Lc124 {
    private int max;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        max = root.val;
        postTraverseMax(root);

        return max;
    }


    public int postTraverseMax(TreeNode root) {

        int res = root.val;

        int vl = 0, vr = 0;
        if (root.left!=null) {
            vl = postTraverseMax(root.left);
            res = Math.max(res, root.val + vl);
        }

        if (root.right!=null) {
            vr = postTraverseMax(root.right);
            res = Math.max(res, root.val + vr);
        }

        max = Math.max(max, res);

        if ((root.left!=null) && (root.right!=null)) {
            max = Math.max(max, vl + vr + root.val);
        }

        return res;
    }
}
