package com.lc.pa;

/**
 * Created by lezh on 11/4/2016.
 */
public class Lc065 {
    public static boolean isNumber(String s) {
        int i = 0;
        boolean res = false;
        for (; (i < s.length()) && (Character.isWhitespace(s.charAt(i))); i++) ;

        if (i >= s.length())
            return res;

        if ((s.charAt(i) == '+') || (s.charAt(i) == '-'))
            i++;

        for (; (i < s.length()) && (Character.isDigit(s.charAt(i))); i++)
            res = true;

        if ((i < s.length()) && (s.charAt(i) == '.'))
            i++;

        for (; (i < s.length()) && (Character.isDigit(s.charAt(i))); i++)
            res = true;


        if ((i < s.length()) && (s.charAt(i) == 'e'))
            if (res == true) {
                i++;
                res = false;
                if (i >= s.length())
                    return res;
                if ((s.charAt(i) == '+') || (s.charAt(i) == '-'))
                    i++;

                for (; (i < s.length()) && (Character.isDigit(s.charAt(i))); i++)
                    res = true;

            } else
                return false;


        for (; (i < s.length()) && (Character.isWhitespace(s.charAt(i))); i++) ;

        if (i >= s.length())
            return res;
        else
            return false;

    }
}
