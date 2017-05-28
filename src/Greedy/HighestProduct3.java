package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/highest-product/
 */
public class HighestProduct3 {
    public int maxp3(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        int highest = a.get(n-1);
        int secondHighest = a.get(n-2);
        int thirdHighest = a.get(n-3);

        int lowest = a.get(0);
        int secondLowest = a.get(1);

        // All negative numbers

        return Math.max(highest*secondHighest*thirdHighest, highest*lowest*secondLowest);

    }
}
