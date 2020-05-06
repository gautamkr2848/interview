package com.interview.string;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccuringChar {

    public void maximumOccuringChar(){
        String s = "apple";
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(array[i]))
                map.put(array[i], map.get(array[i])+1);
            else
                map.put(array[i], 1);
        }

        int max = 0;
        Character c = null;
        for(Character ch : map.keySet()){
            if(map.get(ch) > max){
                max = map.get(ch);
                c = ch;
            }
        }
        System.out.println("Maximum occuring character : "+c);
    }
}
