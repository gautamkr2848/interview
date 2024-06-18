package com.interview;

import com.interview.tree.Node;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 1} ;
        int minSoFar = a[0];
        int profit = 0;

        for(int i=1; i<a.length; i++) {
            if(a[i] < minSoFar) {
                minSoFar = a[i];
            } else if(a[i] - minSoFar > profit) {
                profit = a[i] - minSoFar;
            }
        }
        System.out.println(profit);
    }

    public static void reverseWords(String[] s) {
        int l =0, r = s.length-1;
        while (l<r) {
            String tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }

        for(int i=0; i< s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

    private static String reverse(String s) {
        char[] tmp = s.toCharArray();
        int l=0, r = s.length()-1;

        while (l<r) {
            char c = tmp[l];
            tmp[l] = tmp[r];
            tmp[r] = c;

            l++;
            r--;
        }
        return String.valueOf(tmp);
    }

    public static void stringCombination(String s) {
        char[] a = s.toCharArray();
        int n = s.length();

        for(int i=0; i<Math.pow(2,n); i++) {
            for(int j=0; j<n; j++) {
                if((i & (int) Math.pow(2,j)) > 0) {
                    System.out.print(s.charAt(j) + " ");
                }
            }
            System.out.println();
        }
    }

    private static String swap(String s, int i, int j) {
        char[] tmp = s.toCharArray();
        char a = tmp[i];
        tmp[i] = tmp[j];
        tmp[j] = a;

        return String.valueOf(tmp);
    }
}
