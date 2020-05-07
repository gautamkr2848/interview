package com.interview.string;

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
}
