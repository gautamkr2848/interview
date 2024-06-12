package com.interview.string;

import com.interview.trie.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated
sequence of dictionary words.

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" or "i like sam sung"
*/

public class WordBreak {

    List<String> dictionary = Arrays.asList("mobile","samsung","sam","sung",
            "man","mango","icecream","and",
            "go","i","like","ice","cream");

    public Boolean wordBreak(String word){
        int n = word.length();
        Set<String> dictionary = new HashSet<>();

        dictionary.addAll(dictionary);
        if (n == 0) return true;

        for (int i = 1; i <= n; i++) {
            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,n)))
                return true;
        }
        return false;
    }

    public Boolean wordBreak_2(String word){
        int n = word.length();
        if(word.length() == 0)
            return true;
        Trie trie = new Trie(dictionary);

        for(int i=1; i<=n; i++){
            if(Trie.search(word.substring(0,i)) && wordBreak_2(word.substring(i,n)))
                return true;
        }

        return false;
    }
}