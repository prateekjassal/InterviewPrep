package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/assign-mice-to-holes/
 */
public class MiceHoles {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int max = Integer.MIN_VALUE;

        for(int i=0;i<a.size();i++){
            int m = a.get(i);
            int h = b.get(i);
            int diff = Math.abs(m-h);
            max = Math.max(diff, max);
        }
        return max;
    }
}
