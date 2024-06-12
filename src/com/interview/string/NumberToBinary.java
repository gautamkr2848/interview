package com.interview.string;

//String s = Integer.toBinaryString(i);   where i = number

public class NumberToBinary {

    public void numberToBinary() {
        int n = 11;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int temp = n % 2;
            n = n / 2;
            sb.append(temp);
        }
        System.out.println(sb.reverse());
    }
}
