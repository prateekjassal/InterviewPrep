package Greedy;

import java.util.ArrayList;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/bulbs/
 *
 */
public class LightBulbs {
    public int bulbs(ArrayList<Integer> a) {
        boolean inverted = false;
        int count = 0;

        for(int i=0;i<a.size();i++) {
            int initialState = a.get(i);
            if((initialState == 0 && !inverted) || (initialState == 1 && inverted)) {
                inverted = !inverted;
                count++;
            }
        }
        return count;
    }
}
