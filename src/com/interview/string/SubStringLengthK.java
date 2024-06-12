package com.interview.string;

public class SubStringLengthK {

    public static void SubString(String str, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }
}
