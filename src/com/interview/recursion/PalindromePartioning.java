package com.interview.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromePartioning {

    public void palindromeParioning(){
        String s = "geeks";
        int n = s.length();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        Deque<String> currPart = new LinkedList<>();    // To store current palindromic partition
        partitonsUtil(result, currPart, 0, n, s);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
    }

    private void partitonsUtil(ArrayList<ArrayList<String>> allPart, Deque<String> currPart, int start, int n, String s) {
        if (start >= n) {
            allPart.add(new ArrayList<>(currPart));
            return;
        }

        for (int i = start; i < n; i++) {   // Pick all possible ending points for substrings
            if (isPalindrome(s, start, i)) {
                currPart.addLast(s.substring(start, i + 1));    // Add the substring to result
                partitonsUtil(allPart, currPart, i + 1, n, s);      // Recur for remaining remaining substring
                currPart.removeLast();      // Remove substring str[start..i] from current partition
            }
        }
    }

    private Boolean isPalindrome(String s, int i, int j){
        if(i >= j)
            return true;

        while (i < j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

