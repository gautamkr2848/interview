package com.interview.array.twoPointer;

// Given n length array where vertical lines are drawn                .
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//The program should return an integer which corresponds to the maximum area of water that can be contained (maximum area instead of maximum volume sounds weird but this is the 2D plane we are working with for simplicity).
//
//Note: You may not slant the container.
//
//Examples :
//
//Input: array = [1, 5, 4, 3]
//Output: 6
//Explanation :
//5 and 3 are distance 2 apart.
//So the size of the base = 2.
//Height of container = min(5, 3) = 3.
//So total area = 3 * 2 = 6
//
//Input: array = [3, 1, 2, 4, 5]
//Output: 12
//Explanation :
//5 and 3 are distance 4 apart.
//So the size of the base = 4.
//Height of container = min(5, 3) = 3.
//So total area = 4 * 3 = 12

public class ContainerWithMostWater {

    public static int maxArea_2(int[] a) {
        int area = 0;

        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                area = Math.max(area, Math.min(a[i], a[j]) * (j - i));
            }
        }
        return area;
    }

    private static int maxArea(int A[]) {
        int i = 0;
        int j = A.length - 1;
        int area = 0;

        while (i < j) {     // Calculating the max area
            area = Math.max(area, Math.min(A[i], A[j]) * (j - i));
            if (A[i] < A[j])
                i++;
            else
                j--;
        }
        return area;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};

        System.out.println( maxArea(a));
        System.out.print( maxArea(b) );
    }
}
