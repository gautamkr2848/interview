package com.interview.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartioning {

    public void palindromeParioning(){
        String s = "nitin";
        int n = s.length();
        List<List<String>> result = new ArrayList<>();

        Deque<String> currPart = new LinkedList<>();
        partitonsUtil(result, currPart, 0, n, s);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
    }

    private void partitonsUtil(List<List<String>> result, Deque<String> currPart, int start, int n, String s) {
        if (start >= n) {
            result.add(new ArrayList<>(currPart));
            return;
        }

        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                currPart.addLast(s.substring(start, i + 1));
                partitonsUtil(result, currPart, i + 1, n, s);
                currPart.removeLast();
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

    //Time complexity: O(n*2n)
    //Auxiliary Space: O(n2)
}

