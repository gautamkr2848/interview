package com.interview.array;

public class SortedArraySquare {

    public int[] sortedSquaresSimplified() {
        int[] a = {-5, -2, -1, 0, 4, 6};
        int n = a.length;
        int[] squaredArr = new int[n];
        int highestSquareIdx = n-1;

        int left = 0;
        int right = n-1;

        while(left <= right) {
            int leftSquare = a[left]*a[left];
            int rightSquare = a[right]*a[right];

            if(leftSquare > rightSquare) {
                squaredArr[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squaredArr[highestSquareIdx--] = rightSquare;
                right--;
            }
        }

        return squaredArr;
    }
}
