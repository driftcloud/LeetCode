package com.lc.pa;

/**
 * Created by lezh on 11/6/2016.
 */
public class Lc125 {
    public static boolean isPalindrome(String s) {
        char[] rc = new char[s.length()];

        int len = 0;
        for (int i=0; i<s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                if (Character.isUpperCase(s.charAt(i)))
                    rc[len++] = Character.toLowerCase(s.charAt(i));
                else
                    rc[len++] = s.charAt(i);
            else if (Character.isDigit(s.charAt(i)))
                rc[len++] = s.charAt(i);

        for (int i=0, j=len-1;i<j; i++, j--)
            if (rc[i] != rc[j])
                return false;

        return true;
    }
}
