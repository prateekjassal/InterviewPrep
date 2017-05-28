package TwoPointers;

import java.util.ArrayList;

/**
 * Created by prateek on 23/05/17.
 */
public class MergeSortedLists{

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
//        a.add(1);
        a.add(5);
//        a.add(8);
        ArrayList<Integer> b = new ArrayList();
        b.add(6);
        b.add(9);
        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        mergeSortedLists.merge(a, b);
        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int x = a.size()-1;
        int y = b.size()-1;

        for(int i=0;i<b.size();i++) {
            a.add(-1);
        }

        int z = a.size()-1;
        while(x>=0 && y>=0) {
            int m = a.get(x);
            int n =  b.get(y);
            if(m > n) {
                a.set(z, m);
                x--;
            } else {
                a.set(z, n);
                y--;
            }
            z--;
        }

        while(x>=0) {
            int num = a.get(x);
            a.set(z, num);
            x--;
            z--;
        }
        // 9 12    12%9 = 3    9%3= 0

        while(y>=0) {
            int num = b.get(y);
            a.set(z, num);
            y--;
            z--;
        }
    }
}
