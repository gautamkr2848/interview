package com.interview.string;

public class GenerateAllSubString {

    public static void subString(String str, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }

    public static void main(String[] args) {
        subString("ABC", 3);
    }

    public void printSubStrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            String subStr="";

            for (int j = i; j < str.length(); j++) {
                subStr += str.charAt(j);
                System.out.print(subStr +"\n");
            }
        }
    }
}
