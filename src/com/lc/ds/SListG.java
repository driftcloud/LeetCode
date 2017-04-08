package com.lc.ds;

import java.lang.Integer;
import java.util.ArrayList;
import com.lc.ds.ListNodeG;

/**
 * Created by leizh on 10/26/2016.
 */
public class SListG<T> {
    public int size;
    public ListNodeG<T> head;

    public SListG() {
        size = 0;
        head = null;
    }

    public SListG(ArrayList<T> vin) {
        head = null;
        for (int i = vin.size() - 1; i >= 0; i-- ) {
            add(vin.get(i));
        }
        size = vin.size();
    }

    public SListG(T[] ain) {
        for (int i = ain.length - 1; i >= 0; i-- ) {
            add(ain[i]);
        }
        size = ain.length;
    }

    public SListG(ListNodeG<T> nhead) {
        head = nhead;
        updateSize();
    }

    public void add(T e) {
        ListNodeG<T> cur = new ListNodeG<T>(e);
        cur.next = head;
        head = cur;
        size++;
    }


    public void add(ListNodeG<T> node) {
        node.next = head;
        head = node;
        size++;
    }

    public void dump() {
        for (ListNodeG<T> p=head; p!=null; p=p.next) {
            System.out.print(p.val + "->");
        }
        System.out.println("null");
    }

    public void updateSize() {
        int i=0;
        for (ListNodeG<T> p=head; p!=null; p=p.next)
            i++;
        size = i;
    }
}
