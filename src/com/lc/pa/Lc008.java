package com.lc.pa;

/**
 * Created by lezh on 12/17/2016.
 */
public class Lc008 {
    public static int myAtoi(String str) {

        final int maxDiv10 =  Integer.MAX_VALUE/10;

        int res = 0, i, n = str.length(), sign = 1;
        for (i=0; (i<n) && (Character.isWhitespace(str.charAt(i))); i++);

        if (i>=n)
            return res;

        if (str.charAt(i)=='+')
            i++;
        else if (str.charAt(i)=='-') {
            sign = -1;
            i++;
        }

        int digit;
        for (; (i<n) && (Character.isDigit(str.charAt(i))); i++) {
            digit = str.charAt(i) - '0';
            if ((res > maxDiv10) || ((res == maxDiv10) && (digit > 7)))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + digit;
        }

        return res*sign;
    }
}
