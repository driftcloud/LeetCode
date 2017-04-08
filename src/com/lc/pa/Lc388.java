package com.lc.pa;

import java.util.Stack;

/**
 * Created by lezh on 12/28/2016.
 * Abandon, too easy to get an error condition
 */
public class Lc388 {
    public static int lengthLongestPath(String input) {
        Stack<Integer> pathlen = new Stack<>();
        pathlen.push(0);

        int fmax = 0;
        boolean isfile = false, newline = true;
        for (int i=0, rlen=0, nlevel=0, space=0; i<=input.length(); i++) {
            char ch = i==input.length() ? '\n' : input.charAt(i);
            switch (ch) {
                case '\n':
                    while(space >= 4 && nlevel < pathlen.size() - 1 ) {
                        nlevel++;
                        space -= 4;
                    }
                    rlen += space;
                    if (isfile)
                        fmax = Math.max(fmax, rlen+pathlen.peek());
                    else {
                        for (int j=pathlen.size(); j>nlevel+1; j--)
                            pathlen.pop();
                        pathlen.push(rlen + pathlen.peek() + 1);
                    }
                    nlevel = 0;
                    rlen = 0;
                    space = 0;
                    isfile = false;
                    break;
                case '\t':
                    nlevel++;
                    break;
                case ' ':
                    if ((rlen==0))
                        space++;
                    else
                        rlen++;
                    break;
                case '.':
                    isfile = true;
                    rlen++;
                    break;
                default:
                    rlen++;
            }
        }

        return fmax;
    }
}
