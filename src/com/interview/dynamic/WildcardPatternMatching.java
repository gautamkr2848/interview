package com.interview.dynamic;

import java.util.ArrayList;
import java.util.List;

public class WildcardPatternMatching {

    public void wildcardPatternMatching(){
        String str = "baaabab";
        String pattern = "*****ba*****ab";

        int m = str.length();
        int n = pattern.length();

        if (n == 0)     // empty pattern can only match with empty string
            System.out.println(m == 0);

        boolean[][] temp = new boolean[m + 1][n + 1];
        temp[0][0] = true;      // empty pattern can match with empty string

        for (int j = 1; j <= n; j++)        // Only '*' can match with empty string
            if (pattern.charAt(j - 1) == '*')
                temp[0][j] = temp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*')
                    temp[i][j] = temp[i][j - 1] || temp[i - 1][j];
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    temp[i][j] = temp[i - 1][j - 1];
                else
                    temp[i][j] = false;
            }
        }
        System.out.println(temp[m][n]);
    }

    public boolean wildcardPatternMatching2(){
        String str = "baaabab";
        String pattern = "*****ba*****ab";

        int m = str.length();
        int n = pattern.length();

        if (n == 0)     // empty pattern can only match with empty string
            System.out.println(m == 0);

        List<String> tmp = new ArrayList<>();
        boolean isContinuous = false;
        for(Character c : pattern.toCharArray()) {
            if(c >='a' && c<= 'z') {
                if(isContinuous) {
                    String s = tmp.get(tmp.size() - 1);
                    s = s + c;
                    tmp.remove(tmp.size() - 1);
                    tmp.add(s);
                } else {
                    tmp.add(String.valueOf(c));
                }
                isContinuous = true;
            } else {
                isContinuous = false;
            }
        }

        if(pattern.charAt(0) != '*') {
            if(!tmp.get(0).equals(str.substring(0, tmp.get(0).length()))) {
                return  false;
            }
        }

        if(pattern.charAt(pattern.length() - 1) != '*') {
            if(!tmp.get(tmp.size() - 1).equals(str.substring(str.length() - tmp.get(tmp.size() - 1).length()))) {
                return  false;
            }
        }

        for (int i=0; i<tmp.size() && str.length() > 0; i++) {
            String s = tmp.get(i);
            if(str.contains(s)) {
                str = str.substring(str.indexOf(s) + s.length());
            } else {
                return (false);
            }
        }
        return (true);
    }
}
