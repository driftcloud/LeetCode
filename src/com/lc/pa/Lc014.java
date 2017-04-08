package com.lc.pa;

/**
 * Created by lezh on 12/27/2016.
 */
public class Lc014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return new String();

        StringBuilder res = new StringBuilder();
        boolean more = true;
        int i=0;
        while (true) {
            for (int j = 0; j < strs.length; j++)
                if (i==strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i)) {
                    more = false;
                    break;
                }
            if (more)
                res.append(strs[0].charAt(i));
            else
                break;
            i++;
        }

        return res.toString();
    }
}
