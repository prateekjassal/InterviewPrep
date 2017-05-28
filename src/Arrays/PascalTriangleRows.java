package Arrays;

import java.util.ArrayList;

/**
 * Created by prateek on 28/05/17.
 *
 * Source - https://www.interviewbit.com/problems/pascal-triangle-rows/
 */
public class PascalTriangleRows {
    public static void main(String[] args) {
        System.out.println(new PascalTriangleRows().generate(5));
    }

    public ArrayList<ArrayList<Integer>> generate(int n) {
        ArrayList<ArrayList<Integer>> triangleRows = new ArrayList<ArrayList<Integer>>();
        if(n == 0)
            return triangleRows;

        ArrayList<Integer> prevRow = null;
        ArrayList<Integer> currRow;
        for(int row=1;row<=n;row++) {
            currRow = new ArrayList<Integer>();
            for(int col=1;col<=row;col++) {
                // System.out.println(row+" : "+col+"!");
                if(col == 1 || col == row)
                    currRow.add(1);
                else {
                    // System.out.println(row+" "+col);
                    currRow.add(prevRow.get(col-2)+prevRow.get(col-1));
                }
                // System.out.println(row+" "+currRow);
            }
            triangleRows.add(currRow);
            prevRow = currRow;
        }
        return triangleRows;
    }
}
