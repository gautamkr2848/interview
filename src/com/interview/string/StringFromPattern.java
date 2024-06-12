package com.interview.string;

import java.util.List;

//String input = "1??0?101";

//Output:
//10000101
//10001101
//10100101
//10101101
//11000101
//11001101
//11100101
//11101101

public class StringFromPattern {

    public void genBin(String s, List<String> res) {
        if (s.indexOf('?') != -1) {
            String s1 = s.replaceFirst("\\?", "0"); // only replace once
            String s2 = s.replaceFirst("\\?", "1"); // only replace once
            genBin(s1, res);
            genBin(s2, res);
        }
        else
            res.add(s);
    }

    //Time Complexity: O(N*2N),  where N is the size of the string.
    //Auxiliary Space: O(2N)

    //index will start from 0
    public void generateString(char str[], int index) {
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        if (str[index] == '?') {
            // replace '?' by '0' and recurse
            str[index] = '0';
            generateString(str, index + 1);

            // replace '?' by '1' and recurse
            str[index] = '1';
            generateString(str, index + 1);

            // NOTE: Need to backtrack as string
            // is passed by reference to the
            // function
            str[index] = '?';
        }
        else
            generateString(str, index + 1);
    }

    //Time Complexity: O(2N)
    //Auxiliary Space: O(N2)
}
