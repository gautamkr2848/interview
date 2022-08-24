package com.interview.excel;

public class ColumnNameToNumber {

    public void titleToNumber() {
        String s = "AB";
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + s.charAt(i) - 'A' + 1;

        System.out.println(result);
    }
}
