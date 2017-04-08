package com.lc.pa;

import java.util.*;

/**
 * Created by lezh on 1/8/2017.
 */
public class Lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, LinkedList<String>> wordGraph = new HashMap<>();

        for (String x : wordList) {
            for (String y: wordList)
                if (x != y && wordAdjacent(x, y)) {
                    addToGraph(wordGraph, x, y);
                }

            if (wordAdjacent(beginWord, x)) {
                addToGraph(wordGraph, beginWord, x);
                addToGraph(wordGraph, x, beginWord);
            }

        }

        HashMap<String, Integer> pathLen = new HashMap<>();
        for (String x : wordList)
            pathLen.put(x, 0);
        pathLen.put(beginWord, 1);
        pathLen.put(endWord, 0);

        Queue<String> q = new LinkedList<>();
        //dfs(wordGraph, beginWord, pathLen);
        q.offer(beginWord);
        bfs(wordGraph, pathLen, q);

        return wordGraph.containsKey(endWord) ? pathLen.get(endWord) : 0;
    }

    public boolean wordAdjacent(String a, String b) {
        if (a.length() != b.length())
            return false;

        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }

        if (diff == 1)
            return true;
        else
            return false;
    }

    public void addToGraph(HashMap<String, LinkedList<String>> wordGraph, String a, String b) {
        if (wordGraph.containsKey(a))
            wordGraph.get(a).add(b);
        else {
            LinkedList<String> ll = new LinkedList<>();
            ll.add(b);
            wordGraph.put(a, ll);
        }
    }

    public void dfs(HashMap<String, LinkedList<String>> wordGraph, String v, HashMap<String, Integer> pathLen) {

        for (String x : wordGraph.get(v)) {
            if (pathLen.get(x) == 0) {
                pathLen.put(x, pathLen.get(v) + 1);
                dfs(wordGraph, x, pathLen);
            }
        }
    }

    public void bfs(HashMap<String, LinkedList<String>> wordGraph, HashMap<String, Integer> pathLen, Queue<String> q) {

        while (!q.isEmpty()) {
            String v = q.poll();
            if (wordGraph.containsKey(v)) {
                for (String x : wordGraph.get(v)) {
                    if (pathLen.get(x) == 0) {
                        pathLen.put(x, pathLen.get(v) + 1);
                        q.offer(x);
                    }
                }
            }
        }
    }
}
