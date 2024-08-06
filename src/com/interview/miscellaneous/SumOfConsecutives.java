package com.interview.miscellaneous;

/*Input :15
  Output :3
  15 can be represented as:
  1+2+3+4+5
  4+5+6
  7+8*/

public class  SumOfConsecutives {

    public static void main(String[] args) {
        int n = 15;

        int[] a = new int[n];
        for(int i=1; i<=n; i++)
            a[i-1] = i;

        int currSum = 0, count = 0, j=0;
        for(int i=0; i<n; i++) {
            currSum = currSum + a[i];
            if(currSum == n)
                count++;

            if(a[i] == n)
                count--;

            while (currSum > n) {
                currSum = currSum - a[j];
                j++;

                if(currSum == n)
                    count++;
            }
        }
        System.out.println(count);
    }

}
