package com.lc.pa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lezh on 11/26/2016.
 */
public class Lc386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1, lastd;

        while (true) {

            if (cur <= n) {
                res.add(cur);
                cur *= 10;
            } else {
                do {
                    cur /= 10;
                    if (cur==0)
                        return res;
                    lastd = cur % 10;
                } while (lastd == 9);
                cur++;
            }

        }
    }

}
