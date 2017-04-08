package com.lc.so;

import com.lc.pa.Lc386;

import java.util.List;

/**
 * Created by lezh on 11/30/2016.
 */
public class Sol386 {
    public static void main(String[] args) {

        List<Integer> res = Lc386.lexicalOrder(234);
        for (Integer x : res)
            System.out.println(x);
    }
}
