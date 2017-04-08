package com.lc.ds;

import java.lang.Integer;
import java.util.ArrayList;
import com.lc.ds.ListNode;

/**
 * Created by leizh on 10/26/2016.
 */
public class SList {
    public int size;
    public ListNode head;

    public SList() {
        size = 0;
        head = null;
    }

    public SList(ArrayList<Integer> vin) {
        head = null;
        for (int i = vin.size() - 1; i >= 0; i-- ) {
            add(vin.get(i));
        }
        size = vin.size();
    }

    public SList(int[] ain) {
        for (int i = ain.length - 1; i >= 0; i-- ) {
            add(ain[i]);
        }
        size = ain.length;
    }

    public SList(ListNode nhead) {
        head = nhead;
        updateSize();
    }

    public void add(int e) {
        ListNode cur = new ListNode(e);
        cur.next = head;
        head = cur;
        size++;
    }


    public void add(ListNode node) {
        node.next = head;
        head = node;
        size++;
    }

    public void dump() {
        for (ListNode p=head; p!=null; p=p.next) {
            System.out.print(p.val + "->");
        }
        System.out.println("null");
    }

    public void updateSize() {
        int i=0;
        for (ListNode p=head; p!=null; p=p.next)
            i++;
        size = i;
    }
}
