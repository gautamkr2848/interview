package com.interview.trie;

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

    private Trie trie;

    public WordBreak(){
        List<String> dictionary = Arrays.asList("mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream");
        trie = new Trie(dictionary);
    }

    public Boolean wordBreak_2(String word){
        int n = word.length();
        if(word.length() == 0)
            return true;

        for(int i=1; i<=n; i++){
            if(trie.search(word.substring(0,i)) && wordBreak_2(word.substring(i,n)))
                return true;
        }

        return false;
    }
}