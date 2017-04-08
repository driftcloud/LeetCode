package com.lc.pa;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by lezh on 11/12/2016.
 */
public class Lc151 {
    public static String reverseWords(String s) {
        if ((s==null)||(s.length()==0))
            return new String("");


        char[] ch = s.toCharArray();
        reverseCharArray(ch, 0, ch.length-1);

        StringBuilder res = new StringBuilder();
        Stack<Character> sub_rev = new Stack<>();
        char prev = ' ', cur;
        for (int i=0; i<=ch.length; i++) {
            if (i<ch.length)
                cur = ch[i];
            else
                cur = ' ';
            if (Character.isWhitespace(cur)) {
                if(!Character.isWhitespace(prev)) {
                    if (res.length() > 0)
                        res.append(' ');
                    while (!sub_rev.isEmpty()) {
                        res.append(sub_rev.pop());
                    }
                }
            } else {
                sub_rev.push(cur);
            }
            prev = cur;
        }

        return res.toString();
    }

    public static void reverseCharArray(char[] cha, int lo, int hi) {
        while (lo < hi) {
            char temp = cha[lo];
            cha[lo] = cha[hi];
            cha[hi] = temp;
            lo++;
            hi--;
        }
    }
}
