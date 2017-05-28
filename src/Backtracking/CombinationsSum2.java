package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prateek on 21/05/17.
 *
 * Source - https://www.interviewbit.com/problems/combination-sum-ii/
 */
public class CombinationsSum2 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        candidates.add(2);
        candidates.add(2);
        candidates.add(2);
        candidates.add(2);
        candidates.add(3);
        candidates.add(4);
        candidates.add(6);
        candidates.add(7);
        int target = 6;
        CombinationsSum2 combinationsSum = new CombinationsSum2();
        System.out.println(combinationsSum.combinationSum(candidates, target));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        res.clear();
        Collections.sort(a);
        pickNext(0, b, a, new ArrayList<>(), -1);
        return res;
    }

    public void pickNext(int i, int remaining,  ArrayList<Integer> candidates, ArrayList<Integer> list, int prevSelected) {
        if(remaining == 0)  {
            res.add(new ArrayList<>(list));
            return;
        }

        if(remaining < 0 || i == candidates.size())
            return;

        int num = candidates.get(i);

        if(i>0 && num ==  candidates.get(i-1) && prevSelected != i-1) {
            pickNext(i+1, remaining, candidates, list, prevSelected);
            return;
        }
        list.add(num);
        remaining-=num;
        pickNext(i+1, remaining, candidates, list, i);
        remaining+=num;
        list.remove(list.size()-1);
        pickNext(i+1, remaining, candidates, list, prevSelected);
    }
}
