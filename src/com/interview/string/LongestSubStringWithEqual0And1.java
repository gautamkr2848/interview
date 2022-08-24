package com.interview.string;

import java.util.HashMap;

//longest substring with equal 0 and 1
public class LongestSubStringWithEqual0And1 {

    public void longestSubStringWithEqual0And1(){
        String str = "101001000";
        HashMap<Integer,Integer> map = new HashMap<>();
        map. put(0, -1);
        int res =0;
        int count_0 = 0, count_1 = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='0')
                count_0++;
            else
                count_1++;

            if(map.containsKey(count_1 - count_0))
                res = Math.max(res, (i - map.get(count_1 - count_0)));
            else
                map.put(count_1 - count_0,i);
        }
        System.out.println("Length of longest balanced sub string = "+res);
    }
}
