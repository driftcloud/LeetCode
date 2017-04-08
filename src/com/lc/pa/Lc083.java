package com.lc.pa;

import com.lc.ds.ListNode;

/**
 * Created by lezh on 12/26/2016.
 */
public class Lc083 {
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode prev = head, cur = head.next, tail = head;
        while (cur != null) {
            if (prev.val!=cur.val) {
                tail.next = cur;
                tail = cur;
            }
            prev = cur;
            cur = cur.next;
        }

        tail.next = null;
        return head;

    }
}
