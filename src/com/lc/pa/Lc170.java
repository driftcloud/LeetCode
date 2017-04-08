package com.lc.pa;

import java.util.HashMap;

/**
 * Created by lezh on 11/26/2016.
 */
public class Lc170 {
    public class TwoSum {

        private HashMap<Integer, Integer> tb;

        public TwoSum() {
            tb = new HashMap<>();
        }

        // Add the number to an internal data structure.
        public void add(int number) {
            if (tb.containsKey(number))
                tb.put(number, tb.get(number) + 1);
            else
                tb.put(number, 1);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int value) {
            for (Integer x : tb.keySet()) {
                int target = value - x;
                if (target == x) {
                    if (tb.get(target) > 1)
                        return true;
                } else if (tb.containsKey(target))
                        return true;

            }

            return false;
        }
    }

    public TwoSum twoSum;

    public Lc170() {
        twoSum = new TwoSum();
    }
}
