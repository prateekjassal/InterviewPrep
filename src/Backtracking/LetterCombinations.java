package Backtracking;

import java.util.*;

/**
 * Created by prateek on 21/05/17.
 *
 * Source - https://www.interviewbit.com/problems/letter-phone/
 *
 */
public class LetterCombinations {
    Map<Character, List<Character>> map = new HashMap<>();
    ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("22"));
    }


    public ArrayList<String> letterCombinations(String a) {
        initMap();
        addNext(a, 0, new StringBuilder());
        return res;
    }

    public void addNext(String str, int index, StringBuilder stringBuilder) {
        if(index == str.length())
        {
            res.add(stringBuilder.toString());
            return;
        }

        char curr = str.charAt(index);
        for(char c:map.get(curr)) {
            stringBuilder.append(c);
            addNext(str, index+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


    private void initMap() {
        if(map.size() == 0) {
            map.put('0', Arrays.asList('0'));
            map.put('1', Arrays.asList('1'));
            map.put('2', Arrays.asList('a','b','c'));
            map.put('3', Arrays.asList('d','e','f'));
            map.put('4', Arrays.asList('g','h','i'));
            map.put('5', Arrays.asList('j','k','l'));
            map.put('6', Arrays.asList('m','n','o'));
            map.put('7', Arrays.asList('p','q','r','s'));
            map.put('8', Arrays.asList('t','u','v'));
            map.put('9', Arrays.asList('w','x','y','z'));
        }
        res.clear();
    }

}
