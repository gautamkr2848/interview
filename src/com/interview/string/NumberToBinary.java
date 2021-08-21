package com.interview.string;

//String s = Integer.toBinaryString(i);   where i = number

import java.util.ArrayList;
import java.util.Arrays;

public class NumberToBinary {

    public void numberToBinary() {
        int n = 11;
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            int temp = n % 2;
            n = n / 2;
            sb.append(temp);
        }
        System.out.println(sb.reverse());
    }

    public  void kLargest() {
        int[] a = {1,23,12,9,30,2,50};
        int k = 3;
        int n = a.length;
        Arrays.sort(a);
        ArrayList<Integer> list = new ArrayList<>();

        while(k>0){
            list.add(a[n-1]);
            n--;
            k--;
        }
    }
}
