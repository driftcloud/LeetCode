package com.lc.ds;

import java.util.Arrays;

/**
 * Created by lezh on 11/8/2016.
 */
public class Reader4 {
    public char[] mem_file_buf;
    public int cur_file_pos;

    public Reader4(int nFileSize) {
        mem_file_buf = new char[nFileSize];
        for (int i = 0; i<nFileSize; i++)
            mem_file_buf[i] = (char)i;
        cur_file_pos = 0;
    }

    public void resetFile() {cur_file_pos = 0;}

    public int read4(char[] buf) {
        int nread = cur_file_pos+4 < mem_file_buf.length ? 4 : mem_file_buf.length - cur_file_pos;
        System.arraycopy(mem_file_buf, cur_file_pos, buf, 0, nread);
        return nread;
    }

    public void dumpFile() {
        System.out.println("mem_file_buf: " + Arrays.toString(mem_file_buf));
    }
}
