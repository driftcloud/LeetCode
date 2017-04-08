package com.lc.pa;

import java.util.Stack;

/**
 * Created by lezh on 11/20/2016.
 */
public class Lc020 {
    public boolean isValid(String s) {
        Stack<Character> paren = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    paren.push(ch);
                    break;
                case ')':
                    if (paren.isEmpty() || (paren.pop() != '('))
                        return false;
                    break;
                case ']':
                    if (paren.isEmpty() || (paren.pop() != '['))
                        return false;
                    break;
                case '}':
                    if (paren.isEmpty() || (paren.pop() != '{'))
                        return false;
                    break;
            }
        }
        return paren.isEmpty();
    }
}
