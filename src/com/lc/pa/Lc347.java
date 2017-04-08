package com.lc.pa;

import java.util.*;

/**
 * Created by lezh on 12/26/2016.
 */
public class Lc347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int x : nums) {
            if (hmap.containsKey(x))
                hmap.put(x, hmap.get(x) + 1);
            else
                hmap.put(x, 1);
        }

        HashMap<Integer, PriorityQueue<Integer>> rmap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer x : hmap.keySet()) {
            Integer f = hmap.get(x);
            pq.add(f);
            if (!rmap.containsKey(f))
                rmap.put(f, new PriorityQueue<Integer>());
            rmap.get(f).add(x);
            if (pq.size() > k)
                pq.poll();
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (pq.size() > 0) {
            Integer f = pq.poll();
            res.addFirst(rmap.get(f).poll());
        }

        return res;
    }
}
