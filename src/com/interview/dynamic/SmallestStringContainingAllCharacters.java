package com.interview.dynamic;

import java.util.Arrays;
import java.util.HashMap;

/*Approach: Basically a window of characters is maintained by using two pointers namely start and end.
        These start and end pointers can be used to shrink and increase the size of window respectively.
        Whenever the window contains all characters of given string, the window is shrinked from left side to
        remove extra characters and then its length is compared with the smallest window found so far.
        If in the present window, no more characters can be deleted then we start increasing the size of the
        window using the end until all the distinct characters present in the string are also there in the window.
        Finally, find the minimum size of each window.*/

/*1. Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any
     in the string, mark that index in the array (this is to count all distinct characters in the string).
  2. Take two pointers start and end which will mark the start and end of window.
  3. Take a counter=0 which will be used to count distinct characters in the window.
  4. Now start reading the characters of the given string and if we come across a character which has not been
     visited yet increment the counter by 1.
  5. If the counter is equal to total number of distinct characters, Try to shrink the window.
  6. For shrinking the window -:
     a. If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
     b.Now compare the length of present window with the minimum window length.*/

public class SmallestStringContainingAllCharacters {

    public void SmallestStringContainingAllCharacters() {
        String s = "aabcbcdbca";
        String t = distinctChar(s);
        HashMap<Character, Integer> goal = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        //target dictionary
        for(int k=0; k<t.length(); k++){
            goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
        }

        int i=0, total = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(!goal.containsKey(c)){
                continue;
            }

            //if c is a target character in the goal, and count is < goal, increase the total
            int count = map.getOrDefault(c, 0);
            if(count<goal.get(c)){
                total++;
            }
            map.put(c, count+1);

            //when total reaches the goal, trim from left until no more chars can be trimmed.
            if(total == t.length()){
                while(!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i))>goal.get(s.charAt(i))){
                    char pc = s.charAt(i);
                    if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                        map.put(pc, map.get(pc)-1);
                    }
                    i++;
                }

                if(minLen > j-i+1){
                    minLen = j-i+1;
                    result = s.substring(i, j+1);
                }
            }
        }
        System.out.println(result);
    }

    String distinctChar(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuffer sb = new StringBuffer();
        sb.append(c[0]);
        for(int i=1; i<c.length; i++){
            if(c[i-1] != c[i])
                sb.append(c[i]);
        }
        return sb.toString();
    }
}
