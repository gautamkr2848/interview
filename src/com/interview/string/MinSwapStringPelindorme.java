package com.interview.string;

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
