package com.lc.pa;

import java.util.HashSet;

/**
 * Created by lezh on 11/26/2016.
 */
public class Lc217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x))
                return true;
            else
                set.add(x);
        }

        return false;
    }

}
