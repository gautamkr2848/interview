package com.interview.array.subArray.slidingWindow;

//Smallest window in a String containing all characters of other String

//Input: string = “this is a test string”, pattern = “tist”
//Output: “t stri”
//Explanation: “t stri” contains all the characters of pattern.
//
//Input: string = “geeksforgeeks”, pattern = “ork”
//Output: “ksfor”

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f_StringWindow {

    public static void Minimum_Window() {
        String s = "geeksforgeeks";
        String t = "ork";

        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            System.out.println("");

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int j = 0 , ans = s.length();
        int count = 0;
        String res = s;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) >= 0) {
                    count ++;
                }

                while(count == t.length()) {
                    if((i - j + 1) < ans) {
                        ans = i - j + 1;
                        res = s.substring(j, i+1);
                    }

                    if(map.containsKey(s.charAt(j))) {
                        map.put(s.charAt(j), map.get(s.charAt(j))+1);
                        if(map.get(s.charAt(j)) > 0) {
                            count --;
                        }
                    }
                    j++ ;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Minimum_Window();
    }
}