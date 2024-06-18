package com.interview.array.subArray.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e_SmallestStringContainingAllCharacters {

    public void findSubString() {
        String s = "AABBBCBBAC";
        String str = "AB";

        Set<Character> set = new HashSet<>();
        for(int i=0; i<str.length(); i++)
            set.add(str.charAt(i));

        int i=0, j=0, n = set.size();
        int ans = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (i<s.length()) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0) + 1);
            if(map.size() == n){
                while(map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    j++;
                }
                ans = Math.min(ans, i-j+1);
            }
            i++;
        }
        System.out.println(ans);
    }
}
