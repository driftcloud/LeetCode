package com.lc.pa;

/**
 * Created by lezh on 12/1/2016.
 */
public class Lc186 {
    public void reverseWords(char[] s) {

        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }


        int prevend = 0;
        while (i < s.length) {
            for (i = prevend; (i < s.length) && (s[i] == ' '); i++);
            for (j = i + 1; (j < s.length) && (s[j] != ' '); j++);
            prevend = j;
            j--;
            while (i < j) {
                char temp;
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
            i=prevend;
        }

    }
}
