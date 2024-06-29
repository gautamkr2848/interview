package com.interview;

import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 2, 8, 1};
        int n = a.length;

        merge(a, 0, n-1);

        Arrays.stream(a).forEach(System.out::println);
    }

    private static void merge(int[] a, int low, int high) {
        if(low < high) {
            int mid = low + (high -low) / 2;
            merge(a, low, mid);
            merge(a, mid + 1, high);
            ms(a, low, mid, high);
        }
    }

    private static void ms(int[] a, int low, int mid, int high) {

    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}







