package com.interview.array;

public class MergeTwoSortedArray {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];

        int i=0, j=0, k=0;

        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while(i<m)
            res[k++] = nums1[i++];

        while(j<n)
            res[k++] = nums2[j++];

        for(k=0; k<(m+n); k++)
            nums1[k] = res[k];

        return nums1;
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;

        while(j>=0){        // Now traversing the nums2 array
            // If element at i index of nums1 > element at j index of nums2
            // then it is largest among two arrays and will be stored at k position of nums1
            // using i>=0 to make sure we have elements to compare in nums1 array
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--; //updating pointer for further comparisons
            }else{
                // element at j index of nums2 array is greater than the element at i index of nums1 array
                // or there is no element left to compare with the nums1 array
                // and we just have to push the elements of nums2 array in the nums1 array.
                nums1[k] = nums2[j];
                k--;
                j--; //updating pointer for further comparisons
            }
        }
    }
}
