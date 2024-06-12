package com.interview.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Given a string S, partition S such that every substring of that partition is a plaindrome. Return all possible
// palindrome partioning of S.

public class PalindromePartioning {

    public List<List<String>> partition() {
        String s = "nitin";
        List<List<String>> res= new ArrayList<>();
        List<String> curr = new ArrayList<>();
        partition_util(s, curr, res);
        return res;
    }

    private void partition_util(String s, List<String> curr, List<List<String>> res) {
        if(s.length()==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=1;i<=s.length();i++){
            String s1=s.substring(0,i);
            if(isPalindrome(s1)){
                curr.add(s1);
                partition_util(s.substring(i), curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i <= j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

