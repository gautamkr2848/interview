package com.interview.miscellaneous;

import java.util.Arrays;

public class NextGreaterNumber {

    public void nextGreaterNumber(){
        char[] arr = { '5','3','4','9','7','6' };
        int i;
        for (i = arr.length - 1; i > 0; i--)
            if (arr[i] > arr[i - 1])
                break;

        if(i == 0)
            System.out.println("Not possible");
        else {
            int x = arr[i - 1], min = i;

            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] > x && arr[j] < arr[min])
                    min = j;

            char temp = arr[i - 1];
            arr[i - 1] = arr[min];
            arr[min] = temp;

            Arrays.sort(arr, i, arr.length);
            for (i = 0; i < arr.length; i++)
                System.out.print(arr[i]);
        }
    }
}
