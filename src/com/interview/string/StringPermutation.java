package com.interview.string;

//Input: S = “ABC”
//Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

public class StringPermutation {

    public void permutation(String str, int l, int r){
        if (l == r)
            System.out.print(str + " ");
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutation(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
