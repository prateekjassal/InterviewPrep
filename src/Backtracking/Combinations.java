package Backtracking;

import java.util.ArrayList;

/**
 * Created by prateek on 20/05/17.
 *
 * Source - https://www.interviewbit.com/problems/combinations/
 */
public class Combinations {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 3));
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res.clear();
        addNext(new ArrayList<Integer>(), 1, k, n);
        return res;
    }

    public void addNext(ArrayList<Integer> list, int i, int k, int n) {
        if(list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        if(i>n) {
            return;
        }

        list.add(i);
        addNext(list, i+1, k, n);
        list.remove(list.size()-1);
        addNext(list, i+1, k, n);
    }


}
