package com.lc.pa;

/**
 * Created by lezh on 11/7/2016.
 */
public class Lc009 {
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;

        int rev, temp;
        for (temp=x, rev = 0; temp>0; temp/=10)
            rev = rev*10 + temp%10;

        return rev-x == 0;
    }
}
