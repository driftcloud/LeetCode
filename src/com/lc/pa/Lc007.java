package com.lc.pa;

/**
 * Created by leizh on 10/29/2016.
 */
public class Lc007 {
    public static int reverse(int x) {
        int sign = 1;
        if (x<0)
            sign = -1;

        int rev = 0, rem = sign*x, cur=0;
        while (rem>0) {
            cur = rem%10;
            if (rev>(Integer.MAX_VALUE-cur)/10)
                return 0;
            rev = rev*10 + cur;
            rem = rem/10;
        }

        return sign*rev;
    }
}
