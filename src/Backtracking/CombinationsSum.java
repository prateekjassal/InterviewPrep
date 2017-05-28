package Backtracking;

import java.util.ArrayList;

/**
 * Created by prateek on 21/05/17.
 *
 * Source - https://www.interviewbit.com/problems/combination-sum/
 *
 */
public class CombinationsSum {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        candidates.add(2);
        candidates.add(2);
        candidates.add(3);
        candidates.add(6);
        candidates.add(7);
        int target = 7;
        CombinationsSum combinationsSum = new CombinationsSum();
        System.out.println(combinationsSum.combinationSum(candidates, target));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        res.clear();
        pickNext(0, b, a, new ArrayList<>());
        return res;
    }

    public void pickNext(int i, int remaining,  ArrayList<Integer> candidates, ArrayList<Integer> list) {
        if(remaining == 0)  {
            res.add(new ArrayList<>(list));
            return;
        }

        if(remaining < 0 || i == candidates.size())
            return;

        int num = candidates.get(i);

        if(i>0 && num ==  candidates.get(i-1)) {
            pickNext(i+1, remaining, candidates, list);
            return;
        }

        int count = 0;

        // Add maximum number of current values that can be added
        while(remaining>0) {
            list.add(num);
            remaining-=num;
            count++;
        }

        while(count>0) {
            pickNext(i+1, remaining, candidates, list);
            remaining+=num;
            list.remove(list.size()-1);
            count--;
        }
        pickNext(i+1, remaining, candidates, list);
    }
}
