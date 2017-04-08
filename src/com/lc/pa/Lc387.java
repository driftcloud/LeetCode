package com.lc.pa;

import java.util.Arrays;

/**
 * Created by lezh on 11/27/2016.
 */
public class Lc387 {
    public int firstUniqChar(String s) {

        int[] hist = new int[256];
        Arrays.fill(hist, -1);

        for (int i=0; i<s.length(); i++) {
            int ch = s.charAt(i);
            if (hist[ch]==-1)
                hist[ch] = i;
            else if (hist[ch] >= 0)
                hist[ch] = -2;
        }

        int res = s.length();
        for (int i=0; i<256; i++) {
            if ((hist[i]>=0) && (hist[i]<res))
                res = hist[i];
        }

        return res==s.length() ? -1 : res;
    }
}
