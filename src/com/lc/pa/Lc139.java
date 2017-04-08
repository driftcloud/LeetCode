package com.lc.pa;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lezh on 1/8/2017.
 */
public class Lc139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length(), m = wordDict.size();
        if (n == 0 || m == 0)
            return false;

        Set<Integer> range = new HashSet<>();

        for (String x : wordDict) {
            range.add(x.length());
        }

        boolean[] breakable =  new boolean[n];

        for (int i=n-1; i>=0; i--) {
            for (Integer j : range) {
                int l = i + j;
                if (l <= n)
                    breakable[i] |= (l == n ? true : breakable[l]) &&
                            wordDict.contains(s.substring(i, l));
            }

        }

        return breakable[0];
    }
}
