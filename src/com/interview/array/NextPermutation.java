package com.interview.array;

/*
Follow the steps below to implement the above observation:

Iterate over the given array from end and find the first index (pivot) which doesn’t follow property of non-increasing
suffix, (i.e,  arr[i] < arr[i + 1]).

Check if pivot index does not exist
This means that the given sequence in the array is the largest as possible. So, swap the complete array.

Otherwise, Iterate the array from the end and find for the successor of pivot in suffix.

Swap the pivot and successor

Minimize the suffix part by reversing the array from pivot + 1 till N.

Initial Sequence    2   4   1   7   5   0

Longest Non Increasing Suffix   7   5   0

Pivot   1

Swap Pivot & right most greater element   2   4   5   7   1   0         // for 1 right most greater element is 5

Reverse suffix      2   4   5   0   1   7


{ 1, 2, 3, 6, 5, 4 }

6 5 4

pivot 3

1 2 4 6 5 3     // for 3 right most greater element is 4

1 2 4 3 5 6
*/

public class NextPermutation {


        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i])
                i--;

            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i])
                    j--;

                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

}
