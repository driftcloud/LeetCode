package com.lc.pa;

import com.lc.ds.UndirectedGraphNode;

import java.util.HashMap;

/**
 * Created by leizh on 10/29/2016.
 */
public class Lc133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        HashMap<UndirectedGraphNode, UndirectedGraphNode> vi=new HashMap<>();
        return dfsClone(node, vi);

    }

    public UndirectedGraphNode dfsClone(UndirectedGraphNode src, HashMap<UndirectedGraphNode, UndirectedGraphNode> vi) {
        if (src==null)
            return null;

        UndirectedGraphNode des, y;
        if (!vi.containsKey(src)) {
            des = new UndirectedGraphNode(src.label);
            vi.put(src, des);
        } else
            des = vi.get(src);

        for (UndirectedGraphNode x : src.neighbors) {
            if (!vi.containsKey(x)) {
                y = new UndirectedGraphNode(x.label);
                vi.put(x, y);
                des.neighbors.add(y);
                dfsClone(x, vi);
            } else {
                y = vi.get(x);
                des.neighbors.add(y);
            }

        }

        return des;
    }

}
