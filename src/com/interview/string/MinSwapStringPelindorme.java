package com.interview.string;

/*
    1. Take two-pointer where the first pointer track from the left side of a string
        and second pointer keep track from the right side of a string.
    2. Till the time we find the same character, keep moving the right pointer to one step left.
    3. If the same character not found then return -1.
    4. If the same character found then swap the right pointer’s character towards the
        right until it is not placed at its correct position in a string.
    5. Increase left pointer and repeat step 2.
*/

public class MinSwapStringPelindorme {

    public void minSwapStringPelindorme(){
        String s = "aabcb";
        int n = s.length();
        int count = 0;

        char[] c = s.toCharArray();
        for(int i=0; i<n/2; i++){
            int left = i;
            int right = n - left -1;

            while (left < right){
                if (c[left] == c[right])
                    break;
                else
                    right--;
            }

            if(left == right)
                System.out.println(-1);
            else if (c[left] != c[n - left - 1]) {
                char temp = c[right];
                c[right] = c[n - left - 1];
                c[n - left - 1] = temp;
                count++;
            }
        }
        System.out.println(count);
    }
}
