package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prateek on 20/05/17.
 */

/**
 * Source - https://www.interviewbit.com/problems/distinct-numbers-in-window/
 *
 *
 */


public class DistinctNumbersWindow {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        DistinctNumbersWindow distinctNumbersWindow = new DistinctNumbersWindow();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(3);
        int windowSize = 3;
        System.out.println(distinctNumbersWindow.dNums(arr, windowSize));

    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int windowSize) {
        map.clear();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=0;i<A.size();i++) {
            int num = A.get(i);
            if(i<windowSize-1) {
                addToMap(num);
            } else {
                if(i>=windowSize) {
                    int prevNum = A.get(i-windowSize);
                    removeFromMap(prevNum);
                }
                addToMap(num);
                res.add(map.size());
            }
        }
        return res;
    }

    private void removeFromMap(int key) {
        int count = map.get(key);
        if(count == 1)
            map.remove(key);
        else
            map.put(key, count-1);

    }

    private void addToMap(int key) {
        if(map.containsKey(key))
            map.put(key, map.get(key)+1);
        else
            map.put(key, 1);
    }
}

