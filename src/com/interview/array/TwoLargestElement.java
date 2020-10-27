package com.interview.array;

public class TwoLargestElement {

    public void twoLargestElement(){
        int[] a = { 12, 35, 1, 10, 34, 1 };
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        if(a.length < 2)
            System.out.println("Invalid Input");

        for(int i = 0; i < a.length; i++)   //find largest number
            largest = Math.max(largest, a[i]);

        for(int i = 0; i < a.length; i++){      // Find the second largest element
            if (a[i] != largest)
                second = Math.max(second, a[i]);
        }

        if (second == Integer.MIN_VALUE)
            System.out.printf("There is no second largest element\n");
        else
            System.out.printf("The second largest element is %d\n", second);
    }
}
