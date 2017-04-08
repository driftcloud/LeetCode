package com.lc.ds;

import com.lc.ds.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leizh on 10/28/2016.
 */
public class UndirectedGraph {
    private final int V;
    private int E;
    public UndirectedGraphNode src;
    public List<Integer>[] adj;

    public UndirectedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new Object[V];
    }

    public UndirectedGraph(String ser) {
        String[] aser = ser.split("#");
        this.V = aser.length;
        adj = (LinkedList<Integer>[]) new Object[V];

        for (int i=0; i<aser.length; i++) {
            String[] ln = aser[i].split(",");
            for (int j=0; j<ln.length; j++) {

            }
        }

    }

    public int V() {return V;}
    public int E() {return E;}
}
