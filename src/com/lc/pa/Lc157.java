package com.lc.pa;

import com.lc.ds.Reader4;

/**
 * Created by lezh on 11/8/2016.
 */
public class Lc157 {

    public static int read(char[] buf, int n, Reader4 rd) {

        int ntotal = 0, pos = 0;
        char[] rd4buf = new char[4];

        while (ntotal < n) {
            int ntarget = n - ntotal;
            int ncur = rd.read4(rd4buf);
            int i, ndone = Math.min(ncur, ntarget);
            for (i = 0; i<ndone; i++)
                buf[pos++] = rd4buf[i];
            ntotal += ndone;
            if (ncur < 4)
                break;
        }

        return ntotal;
    }
}
