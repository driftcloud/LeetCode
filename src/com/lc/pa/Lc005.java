package com.lc.pa;

/**
 * Created by lezh on 11/3/2016.
 */
public class Lc005 {
    public static String longestPalindrome(String s) {

        int[][] plen = new int[s.length()][s.length()];
        int i, maxpl = 1, maxi = 0, maxj = 0;

        for (i=0; i<s.length(); i++) {
            plen[i][i] = 1;
            if (i<s.length()-1) {
                plen[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 0;
                if (plen[i][i + 1] > maxpl) {
                    maxpl =  plen[i][i + 1];
                    maxi = i;
                    maxj = i+1;
                }
            }
        }

        for (int d=2; d <s.length(); d++)
            for (i=0; i<s.length()-d; i++) {
                plen[i][i+d] = s.charAt(i) == s.charAt(i+d) ? (plen[i+1][i+d-1] > 0? plen[i+1][i+d-1] + 2: 0 ) : 0;
                if (plen[i][i+d] > maxpl) {
                    maxpl =  plen[i][i+d];
                    maxi = i;
                    maxj = i+d;
                }
            }

        return s.substring(maxi, maxj+1);
    }
}
