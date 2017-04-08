package com.lc.pa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lezh on 2/20/2017.
 */
public class Lc251 {
    public class Vector2D implements Iterator<Integer> {

        Iterator<Integer> iterX;
        Iterator<List<Integer>> iterY;

        public Vector2D(List<List<Integer>> vec2d) {
            iterY = vec2d.iterator();
            if (iterY.hasNext())
                iterX =  iterY.next().iterator();
            else {
                List<Integer> temp = new ArrayList<>();
                iterX = temp.iterator();
            }
        }

        @Override
        public Integer next() {

            return iterX.next();

        }

        @Override
        public boolean hasNext() {
            if (iterX.hasNext())
                return true;

            while (iterY.hasNext()) {
                iterX = iterY.next().iterator();
                if (iterX.hasNext())
                    return true;
            }

            return false;

        }
    }

}
