package com.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

        /*
        ((()))
        (()())
        (())()
        ()(())
        ()()()*/

public class GenerateParenthesis {

    public void generateParenthesis(){
        int n = 3;
        int open = 0, close = 0;
        List<String> result = new ArrayList<>();
        backtrack(result, "", open, close, n);

        for(int i=0; i<result.size(); i++)
            System.out.println(result.get(i));
    }

    private void backtrack(List<String> result, String cur, int open, int close, int n){
        if (cur.length() == n * 2) {
            result.add(cur);
            return;
        }
        if (open < n) {
            backtrack(result, cur + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, cur + ")", open, close + 1, n);
        }
    }
}
