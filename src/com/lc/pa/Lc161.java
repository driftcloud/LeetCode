package com.lc.pa;

/**
 * Created by lezh on 11/13/2016.
 */
public class Lc161 {

    public static boolean isOneEditDistance(String s, String t) {
        String ls, ss;
        if (s.length() > t.length()) {
            ls = s;
            ss = t;
        } else {
            ls = t;
            ss = s;
        }

        if (ls.length() - ss.length() > 1)
            return false;

        int d = 0, i;
        if (ls.length() == ss.length()) {
            for (i = 0; i < ls.length(); i++)
                if (ls.charAt(i) != ss.charAt(i))
                    d++;
            return d == 1;

        } else {
            for (i = 0; (i < ss.length()) && (d < 2); i++)
                if (ls.charAt(i+d) != ss.charAt(i)) {
                    d++;
                    i--;
                }
            return d < 2;
        }
    }
}
