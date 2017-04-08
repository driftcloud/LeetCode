package com.lc.util;

/**
 * Created by leizh on 10/26/2016.
 */
public class Conv {
    public static Integer[] ArrayInt2Integer(int[] ain) {
        if (ain==null)
            return null;

        Integer[] aout = new Integer[ain.length];
        for (int i=0; i<ain.length; i++) {
            aout[i] = new Integer(ain[i]);
        }

        return aout;
    };
}