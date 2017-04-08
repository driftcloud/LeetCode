package com.lc.pa;

/**
 * Created by lezh on 11/14/2016.
 */
public class Lc028 {
    public int strStr(String haystack, String needle) {

        int i, j;
        for (i=0; ; i++)
            for (j=0; ; j++) {

                if (j>=needle.length())
                    return i;
                if (i+j >= haystack.length())
                    return -1;
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
        }

    }
}
