package com.interview.string;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List ans = new ArrayList();
        dfs(S.toLowerCase().toCharArray(), ans, 0, S.length());
        return ans;
    }

    private void dfs(char[] arr, List ans, int i, int len) {
        if (i < len) {
            dfs(arr, ans, i+1, len);
            if (Character.isLetter(arr[i])) {
                arr[i] = Character.toUpperCase(arr[i]);
                dfs(arr, ans, i+1, len);
                arr[i] = Character.toLowerCase(arr[i]);
            }
        } else
            ans.add(new String(arr));
    }
}
