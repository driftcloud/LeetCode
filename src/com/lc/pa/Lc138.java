package com.lc.pa;

import com.lc.ds.RandomListNode;
import java.util.HashMap;

/**
 * Created by leizh on 10/31/2016.
 */
public class Lc138 {
    public static RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
       RandomListNode psrc = head, pdes, newhead=null;
        while (psrc!=null) {
            pdes = new RandomListNode(psrc.label);
            map.put(psrc, pdes);
            psrc = psrc.next;
        }

        psrc = head;
        while (psrc!=null) {
            pdes = map.get(psrc);
            pdes.next = psrc.next==null ? null : map.get(psrc.next);
            pdes.random = psrc.random==null? null : map.get(psrc.random);
            if (newhead==null)
                newhead = pdes;

            psrc = psrc.next;
        }

        return newhead;
    }
}
