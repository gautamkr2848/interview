package com.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    public void nonRepeatingCharacter(){
        String s = "geeksforgeeks";
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);

        for(Map.Entry<Character, Integer> i : map.entrySet()){
            if(i.getValue() == 1) {
                System.out.println(i.getKey());
                return;
            }
        }
    }
}
