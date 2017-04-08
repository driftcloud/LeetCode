package com.lc.so;

import com.lc.ds.SListG;
import com.lc.pa.Lc002Add2Num;
import com.lc.util.Conv;

public class Sol002 {


    // com.lc.pa.Lc002
    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        Integer[] ai = Conv.ArrayInt2Integer(a);

        SListG<Integer> sa = new SListG<>(ai);
        System.out.print("sa = ");
        sa.dump();

        int[] b = {5, 9};
        Integer[] bi = Conv.ArrayInt2Integer(b);
        SListG<Integer> sb = new SListG<>(bi);
        System.out.print("sb = ");
        sb.dump();

        SListG<Integer> sr = new SListG<>(Lc002Add2Num.addTwoNumbers(sa.head, sb.head));
        System.out.print("sr = ");
        sr.dump();

    }

}
