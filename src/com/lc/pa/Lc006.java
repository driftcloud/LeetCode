package com.lc.pa;

/**
 * Created by leizh on 10/27/2016.
 */
public class Lc006 {
    public static String convert(String s, int numRows) {

        if (numRows<1)
            return null;
        else if (numRows == 1)
            return s;

        // Skip list for each row
        int[] sk = new int[numRows];
        int i,j,k;
        for(i=0; i<numRows-1; i++)
            sk[i] = 2*(numRows-1-i);
        sk[numRows-1] = 3*(numRows-1);

        char[] res = new char[s.length()];

        //row 0
        for(j=0, k=0; j<s.length(); j+=sk[i])
            res[k++] = s.charAt(j);

        //row 1 ~ numRows-2
        for(i=1; i<numRows-1; i++) {
            int cur_sk;
            int step;
            for (j = i, step=0, cur_sk = sk[i]; j < s.length(); j += cur_sk, step++) {

                res[k++] = s.charAt(j);
                if (step%2 == 0)
                    cur_sk = sk[i];
                else
                    cur_sk = sk[numRows-1-i];
            }
        }

        //row numRows-1
        for(j=numRows-1; j<s.length(); j+=sk[i])
            res[k++] = s.charAt(j);

        return String.valueOf(res);
    }
}
