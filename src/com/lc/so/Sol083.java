package com.lc.so;

import com.lc.ds.SList;
import com.lc.pa.Lc083;

/**
 * Created by lezh on 12/27/2016.
 */
public class Sol083 {
    public static void main(String[] args) {
        int[] a = {1, 1, 2};

        SList sa = new SList(a);
        System.out.print("sa = ");
        sa.dump();



        SList sr = new SList(Lc083.deleteDuplicates(sa.head));
        System.out.print("sr = ");
        sr.dump();

    }
}
