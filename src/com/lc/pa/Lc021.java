package com.lc.pa;

import com.lc.ds.ListNode;
/**
 * Created by lezh on 11/14/2016.
 */
public class Lc021 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, res = new ListNode(0), pr=res;

        while ((p1!=null) && (p2!=null)) {
            if (p1.val < p2.val) {
                pr.next = p1;
                p1 = p1.next;
            } else {
                pr.next = p2;
                p2 = p2.next;
            }
            pr = pr.next;
        }

        pr.next = p1 == null ? p2 : p1;

        return res.next;
    }
}
