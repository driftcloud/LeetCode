package com.lc.ds;
import java.util.*;

/**
 * Created by leizh on 10/28/2016.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode() {
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
