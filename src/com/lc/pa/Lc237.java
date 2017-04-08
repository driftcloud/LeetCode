package com.lc.pa;

import com.lc.ds.ListNode;
/**
 * Created by lezh on 11/7/2016.
 */
public class Lc237 {
    public static void deleteNode(ListNode node) {
        if ((node == null) || (node.next == null))
            return;

        ListNode p = node;
        while (p.next.next != null) {
            p.val = p.next.val;
            p = p.next;
        }

        p.val = p.next.val;
        p.next = null;
    }
}
