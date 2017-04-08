package com.lc.so;

import com.lc.pa.Lc388;

/**
 * Created by lezh on 1/2/2017.
 */
public class Sol388 {
    public static void main(String[] args) {
        //String a = "dir\n        file.txt";
        String a = "file name with  space.txt";
        System.out.println(a);
        System.out.println(" -> " + Lc388.lengthLongestPath(a));
    }
}
