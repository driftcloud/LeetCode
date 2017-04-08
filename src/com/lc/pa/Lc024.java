package com.lc.pa;

import com.lc.ds.ListNode;

/**
 * Created by lezh on 11/9/2016.
 */
public class Lc024 {
    public static ListNode swapPairs(ListNode head) {

        ListNode revhead=new ListNode(0), p=head, q=revhead;

        int cnt = 0;

        while (p!=null) {
            head = p.next;

            p.next = q.next;
            q.next = p;

            if ((cnt&1) == 1) {
                q = q.next.next;
            }

            p = head;
            cnt++;
        }

        return revhead.next;

    }
}
