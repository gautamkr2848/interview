package com.interview.backtracking;

/*
1. Create a global variable that will store the maximum string or number.
2. Define a recursive function that takes the string as a number and value of k
3. Run a nested loop, the outer loop from 0 to the length of string n-1, and the inner loop from i+1 to the end of the string.
4. Swap the ith and jth character and check if the string is now maximum and update the maximum string.
5. Call the function recursively with parameters: string and k-1.
6. Now again swap back the ith and jth character.

Time Complexity: O(N pow k)
Auxiliary Space: O(N)

Input: M = 254, K = 1
Output: 524
Explanation: Swap 5 with 2 so number becomes 524

Input: M = 254, K = 2
Output: 542
 */

public class MaxAfterKSwap {

    static String max = "";
    public static void findMaximum(String s, int k) {
        findMaximumNum(s.toCharArray(), k);
        System.out.println(max);
    }

    private static void findMaximumNum(char[] arr, int k) {
        int n = arr.length;
        if (k == 0)
            return;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {       // Compare it with all digits after it

                if (arr[i] < arr[j]) {
                    swap(arr, i, j);

                    if (String.valueOf(arr).compareTo(max) > 0)
                        max = String.valueOf(arr);

                    findMaximumNum(arr, k - 1);
                    swap(arr, i, j);
                }
            }
        }
    }

    private static char[] swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
    }

    public static void main(String[] args) {
        findMaximum("237", 2);
    }
}
