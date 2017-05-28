package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/distribute-candy/
 */
public class CandyDistribution {
    public int candy(ArrayList<Integer> ratings) {
        ArrayList<IndexValue> list = new ArrayList<IndexValue>();
        for(int i=0;i<ratings.size();i++) {
            list.add(new IndexValue(i, ratings.get(i)));
        }

        int sum = 0;

        Collections.sort(list);
        int arr[] = new int[list.size()];
        for(IndexValue iv: list) {
            int index = iv.index;
            int currCandy = 1;
            if(index-1>=0 && ratings.get(index-1)<iv.value)
                currCandy = arr[index-1];
            if(index+1<arr.length && ratings.get(index+1)<iv.value)
                currCandy = Math.max(currCandy, arr[index+1]);


            // System.out.println(index+" "+currValue);
            arr[index] = currCandy+1;
            sum = sum+currCandy;
        }
        return sum;
    }

    class IndexValue implements Comparable<IndexValue> {
        int index;
        int value;
        public IndexValue(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(IndexValue o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
