package com.lc.so;

import com.lc.pa.Lc127;

import java.util.*;

/**
 * Created by lezh on 2/2/2017.
 */
public class Sol127 {
    public static void main(String[] args) {
        Lc127 sol = new Lc127();
        String[] wordArray = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(wordArray);
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(" -> " + sol.ladderLength(beginWord, endWord, wordList));

    }
}
