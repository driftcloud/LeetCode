package com.lc.so;

import com.lc.pa.Lc003;

/**
 * Created by leizh on 10/30/2016.
 */
public class Sol003 {
    public static void main(String[] args) {
        String a = new String("abcabcbb");
        System.out.println(a + " : " + Lc003.lengthOfLongestSubstring(a));

        String b = new String("bbbbbbb");
        System.out.println(b + " : " + Lc003.lengthOfLongestSubstring(b));

        String c = new String("abba");
        System.out.println(c + " : " + Lc003.lengthOfLongestSubstring(c));
    }
}
