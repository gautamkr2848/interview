package com.interview.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PhoneNumberCombination {

    public static void main(String[] args) {
        int[] number = {5,2,4,3};
        int n = 4;
        String[] table = { "0",   "1",   "abc",  "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        System.out.println(letterCombinationsUtil(number, n, table).toString());
    }

    private static List<String> letterCombinationsUtil(int[] number, int n, String[] table) {
        List<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.poll();

            if (s.length() == n)
                list.add(s);
            else {
                String val = table[number[s.length()]];
                for (int i = 0; i < val.length(); i++)
                    q.add(s + val.charAt(i));
            }
        }
        return list;
    }
}
