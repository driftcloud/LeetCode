package com.lc.pa;

import com.lc.ds.ListNodeG;

/**
 * Created by leizh on 10/25/2016.
 */
public class Lc002Add2Num {
    public static ListNodeG<Integer> addTwoNumbers(ListNodeG<Integer> l1, ListNodeG<Integer> l2) {
        int car = 0, cur = 0;
        ListNodeG<Integer> rhead = null, p = null, lr = null;

        while( (l1!=null) && (l2!=null)) {
            cur = (l1.val + l2.val + car) % 10;
            car = (l1.val + l2.val + car) / 10;
            p = new ListNodeG<Integer>(cur);
            p.next = rhead;
            rhead = p;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1!=null)
            lr = l1;
        else if (l2!=null)
            lr = l2;

        while (lr!=null) {
            cur = (lr.val + car) % 10;
            car = (lr.val + car) / 10;
            p = new ListNodeG<Integer>(cur);
            p.next = rhead;
            rhead = p;

            lr = lr.next;
        }

        if (car > 0) {
            p = new ListNodeG<Integer>(car);
            p.next = rhead;
            rhead = p;
        }

        for (p = rhead, rhead=null; p!=null; ) {
            lr = p;
            p=p.next;
            lr.next = rhead;
            rhead = lr;
        }

        return rhead;
    }
}
