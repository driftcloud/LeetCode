package com.lc.pa;

import com.lc.ds.ListNode;

/**
 * Created by lezh on 11/14/2016.
 */
public class Lc160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;
        ListNode p = headA, q;
        while (p!=null) {
            lenA++;
            p=p.next;
        }

        p = headB;
        while (p!=null) {
            lenB++;
            p=p.next;
        }

        int ndiff, nrem;
        if (lenA > lenB) {
            ndiff = lenA - lenB;
            nrem = lenB;
            p = headA;
            q = headB;
        } else {
            ndiff = lenB - lenA;
            nrem = lenA;
            p = headB;
            q = headA;
        }

        for (int i=0; i<ndiff; i++)
            p = p.next;

        for (int i=0; i<nrem; i++, p=p.next, q=q.next)
            if (p == q)
                return p;

        return null;
    }
}
