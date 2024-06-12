package com.interview.array;

import java.util.Stack;

//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
public class MaxJminusI {

    public void max(){
        int[] a = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = a.length;
        int maxDiff = -1;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>i; j++){
                if(a[i] < a[j] && maxDiff < (j - i))
                    maxDiff = j-i;
            }
        }
        System.out.println(maxDiff);
    }

    public int maxIndexDiff(int a[], int n) {

        Stack<Integer> stk = new Stack<>();

        //loop for storing index in stack whose value appears in decreasing order
        for(int i=0;i<n;i++){
            if(stk.isEmpty() || a[stk.peek()] > a[i])
                stk.push(i);
        }

        int maxDiff = 0;

        //Now we traverse from right to left.
        int i = n-1;
        while(i >= 0){

            /*
            This will compare top value of array at index stack top.
            if it satisfy our condition we check the difference  and update out result.
            else we decrement our counter
            */
            if(!stk.isEmpty() && a[stk.peek()] <= a[i]){
                int tmp = i - stk.pop();
                if(tmp > maxDiff){
                    maxDiff  = tmp;
                }
                continue;
            }
            i--;
        }

        return maxDiff;
    }

    public void max_2(){
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = arr.length;
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];


        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);

        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);

        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }
        System.out.println(maxDiff);
    }
}
