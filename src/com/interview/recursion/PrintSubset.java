package com.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubset {

    public void printSubset(int arr[], int k) {
        int tmp[] = new int[k];        // A temporary array to store all combination one by one
        combinationUtil(arr, k, tmp,0, 0);        // Print all combination using temporary array 'data[]'
    }

    private void combinationUtil(int arr[], int k, int tmp[], int curr, int left) {

        if (curr == k) {       // Current combination is ready to be printed
            for (int i = 0; i < k; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println("");
            return;
        }

        if (left >= arr.length)
            return;

        tmp[curr] = arr[left];
        combinationUtil(arr, k, tmp, curr + 1, left + 1);
        combinationUtil(arr, k, tmp, curr, left + 1);
    }


// arr = 5 2 6 8 4
// k = 3, curr = 0, tmp = empty array of size 3, left =0

// 1st iteration
// combinationUtil(arr, 3, 0, tmp, 0)
// tmp[0] = 5

    // 2nd iteration
    // combinationUtil(arr, 3, 1, tmp, 1)
    // tmp[1] = 2

        // 3nd iteration
        // combinationUtil(arr, 3, 2, tmp, 2)
        // tmp[2] = 6

            //4th iteration
            // combinationUtil(arr, 3, 3, tmp, 3)
            // will print tmp array     =>      5 2 6

        //5th iteration
        // combinationUtil(arr, 3, 2, tmp, 3)
        // tmp[2] = 8

            //6th iteration
            // combinationUtil(arr, 3, 3, tmp, 3)
            // will print tmp array     =>      5 2 8

        //7th iteration
        // combinationUtil(arr, 3, 2, tmp, 4)
        // tmp[3] = 4

            //8th iteration
            // combinationUtil(arr, 3, 3, tmp, 4)
            // will print tmp array     =>      5 2 4




    public static void calcSubset(List<Integer> A, List<List<Integer> > res, List<Integer> curr, int index) {

        res.add(new ArrayList<>(curr));

        for (int i = index; i < A.size(); i++) {
            curr.add(A.get(i));
            calcSubset(A, res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer> > subsets(List<Integer> A) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer> > res = new ArrayList<>();

        int index = 0;
        calcSubset(A, res, curr, index);

        return res;
    }

    // Driver code

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(new Integer[]{1, 2, 3});
        List<List<Integer> > res = subsets(array);

        // Print the generated subsets
        for (List<Integer> subset : res) {
            for (Integer num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}