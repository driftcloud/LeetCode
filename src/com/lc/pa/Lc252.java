package com.lc.pa;

import java.util.TreeMap;

/**
 * Created by lezh on 3/28/2017.
 */
public class Lc252 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        TreeMap<Integer, Integer> segs = new TreeMap<>();
        for (Interval x : intervals) {
            if (segs.containsKey(x.start))
                return false;
            else
                segs.put(x.start, x.end);
        }

        Integer prev = null;
        for (Integer i : segs.keySet()) {
            if (prev != null)
                if (i < prev)
                    return false;
            prev = segs.get(i);
        }

        return true;

    }
}
