package com.interview.dynamic;

public class GenerateAllSubString {

    public void generateAllSubstring(){
        String s = "anitin";

        for (int i = 0; i < s.length(); i++) {
            String subStr = "";
            for (int j = i; j < s.length(); j++) {
                subStr += s.charAt(j);
                System.out.println(subStr);
            }
        }
    }
}
