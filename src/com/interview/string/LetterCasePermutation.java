package com.interview.string;

import java.util.ArrayList;
import java.util.List;

//Input : ab
//Output : AB Ab ab aB

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList();
        dfs(S.toLowerCase().toCharArray(), ans, 0, S.length());
        return ans;
    }

    private static void dfs(char[] arr, List ans, int i, int len) {

        if(i >= len)
            ans.add(new String(arr));
        else  {
            dfs(arr, ans, i+1, len);
            if (Character.isLetter(arr[i])) {
                arr[i] = Character.toUpperCase(arr[i]);
                dfs(arr, ans, i+1, len);
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("ab").toString());
    }
}
