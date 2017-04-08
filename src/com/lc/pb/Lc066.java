package com.lc.pb;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lezh on 11/13/2016.
 */
public class Lc066 {

    public int[] plusOne(int[] digits) {

        if (digits == null)
            return null;

        Stack<Integer> st = new Stack<>();

        int carry = 1, cur;
        for (int i=digits.length-1; i>=0; i--) {
            cur = digits[i] + carry;
            carry = cur/10;
            cur = cur%10;
            st.push(cur);
        }

        int[] res;
        if (carry>0) {
            st.push(carry);
            res = new int[digits.length+1];
        } else
            res = new int[digits.length];

        for (int i=0; i<res.length; i++)
            res[i] = st.pop();

        return res;
    }
}
