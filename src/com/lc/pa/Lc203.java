package com.lc.pa;

import com.lc.ds.ListNode;

/**
 * Created by lezh on 2/28/2017.
 */
public class Lc203 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null )
            return null;

        // find the first non val pos
        ListNode p = head;

        while (p != null && p.val == val)
            p = p.next;

        if (p == null)
            return null;

        ListNode new_head = p, tail = p;
        p = p.next;
        while (p != null) {
            if (p.val != val) {
                tail.next = p;
                tail = p;
            }
            p = p.next;
        }

        tail.next = null;
        return new_head;
    }
}
