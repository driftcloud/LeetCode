package com.lc.pa;

import java.util.HashMap;

/**
 * Created by lezh on 11/2/2016.
 */
public class Lc169 {
    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x))
                map.put(x, 1);
            else
                map.put(x, map.get(x)+1);
        }

        for (Integer x : map.keySet())
            if (map.get(x)>nums.length/2)
                return x.intValue();

        return -1;
    }
}
