package com.lc.pa;

import java.util.Stack;

/**
 * Created by lezh on 11/25/2016.
 */
public class Lc150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> equation = new Stack<>();
        int op1, op2, res;
        for (String s : tokens) {
            if ( s.equals("+") || s.equals("-") ||
                    s.equals("*") || s.equals("/")) {
                op2 = equation.pop();
                op1 = equation.pop();
                if (s.equals("+"))
                    res = op1 + op2;
                else if (s.equals("-"))
                    res = op1 - op2;
                else if (s.equals("*"))
                    res = op1 * op2;
                else
                    res = op1 / op2;
                equation.push(res);
            } else
                equation.push(Integer.parseInt(s));
        }

        return equation.pop();
    }
}
