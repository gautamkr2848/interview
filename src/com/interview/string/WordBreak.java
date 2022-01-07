package com.interview.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public Boolean wordBreak(String word){
        int n = word.length();
        Set<String> dictionary = new HashSet<>();

        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        dictionary.addAll(Arrays.asList(temp_dictionary));
        if (n == 0) return true;

        for (int i = 1; i <= n; i++) {
            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,n)))
                return true;
        }
        return false;
    }
}