package Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by prateek on 22/05/17.
 */
public class PalindromePartitioning {

    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    private Comparator<ArrayList<String>> stringListComparator = new Comparator<ArrayList<String>>() {
        @Override
        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
            int x = 0;
            int y = 0;

            while(x<o1.size() && y<o2.size()) {
                if(o1.get(x).length()!=o2.get(y).length())
                    return Integer.compare(o1.get(x).length(), o2.get(y).length());
                x++;
                y++;
            }
            return 0;
        }
    };

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.result.clear();
        System.out.println(palindromePartitioning.partition("aaabba"));
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        pickNext(new StringBuilder(), 0, a, new ArrayList<String>());
        Collections.sort(result, stringListComparator);
        return result;
    }

    private void pickNext(StringBuilder buffer, int i, String str, ArrayList<String> res) {
        if(i >= str.length()) {
            if(buffer.length() == 0) {
//                System.out.println("Result: "+res);
                result.add(new ArrayList<String>(res));
            }
            return;
        }

        char curr = str.charAt(i);

        if(buffer.length() == 0) {
            // Add as a single character
            res.add(String.valueOf(curr));
            pickNext(buffer, i+1, str, res);
            // Remove character
            res.remove(res.size()-1);
        }

        buffer.append(curr);
//        System.out.println(res+" "+i+" "+buffer+" "+curr);
        pickNext(buffer, i+1, str, res);
        // If the current buffer forms a palindrome, add it to the result set
//        System.out.println(buffer.toString()+" "+isPalindrome(buffer));

        if(buffer.length()>1 && isPalindrome(buffer)) {
//            System.out.println(i+" "+buffer+" "+curr);
            res.add(buffer.toString());
            pickNext(new StringBuilder(), i+1, str, res);
            res.remove(res.size()-1);
        }
        buffer.deleteCharAt(buffer.length()-1);
    }

    private boolean isPalindrome(StringBuilder stringBuilder) {
        int x = 0;
        int y = stringBuilder.length()-1;

        while(x<y) {
            if(stringBuilder.charAt(x) != stringBuilder.charAt(y))
                return false;
            x++;
            y--;
        }
        return true;
    }
}
