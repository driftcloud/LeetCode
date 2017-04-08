package com.lc.so;

import com.lc.ds.Tree;
import com.lc.pa.Lc124;

/**
 * Created by lezh on 11/28/2016.
 */
public class Sol124 {
    public static void main(String[] args) {
        //Integer[] sT = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        //Integer[] sT = {-1,5,null,4,null,null,2,-4};
        Integer[] sT = {1,-2,-3,1,3,-2,null,-1};
        Tree t1 = null;

        try {
            t1 = new Tree(sT);
            t1.dump();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Lc124 so = new Lc124();
        int res = so.maxPathSum(t1.root);
        System.out.println("-> " + res);

    }
}
