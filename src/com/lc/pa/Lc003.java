package com.lc.pa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leizh on 10/30/2016.
 */
public class Lc003 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length()==0)
            return 0;

        HashMap<Character, Integer> h =new HashMap<>();
        int[] dis = new int[s.length()];

        int i;
        for (i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if (!h.containsKey(ch)) {
                if (i==0)
                    dis[i] = 1;
                else
                    dis[i] = dis[i-1] + 1;
            } else {
                dis[i] = Math.min(dis[i-1]+1, i-h.get(ch));
            }
            h.put(ch, i);
        }

        int max = 0;
        for (i=0; i<s.length(); i++){
            max = Math.max(max, dis[i]);
        }

        return max;
    }
}
