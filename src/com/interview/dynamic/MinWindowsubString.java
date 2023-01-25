package com.interview.dynamic;

/*
First check if the length of the string is less than the length of the given pattern, if yes then print "-1"
Store the occurrence of characters of the given pattern in a hash array (say, hash_pat[]).
We will be using two pointer technique basically
Start matching the characters of the pattern with the characters of the string i.e. increment count if a character matches.
Check if (count == length of pattern ) this means a window is found.
If such a window is found, try to minimize it by removing extra characters from the beginning of the current window.
Delete one character from the first and again find this deleted key at right.
If found, then again check if count and pattern length are same and repeat the process.
Update min_length.
Print the minimum length window.
*/

public class MinWindowsubString {

    public void minWindowSubString() {

        String str = "timetopractice";
        String pat = "toc";
        int len1 = str.length();
        int len2 = pat.length();
        int no_of_chars = 256;

        if (len1 < len2)
            System.out.println("-1");

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < len1; i++) {

            hash_str[str.charAt(i)]++;

            if (hash_str[str.charAt(i)] <= hash_pat[str.charAt(i)])
                count++;

            if (count == len2) {
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                int len_window = i - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        if (start_index == -1)
            System.out.println("-1");

        System.out.println(str.substring(start_index, start_index + min_len));

    }
}
