package com.interview.string;

public class MinFlipsToAlternateString {

    public void minFlipsToAlternateString(){
        String s = "110101";
        int number = 0;
        for (int i = 0; i < s.length(); i++) {

            // If there is 1 at even index positions
            if (i % 2 == 0 && s.charAt(i) == '1')
                number++;

            // If there is 0 at odd index positions
            if (i % 2 == 1 && s.charAt(i) == '0')
                number++;
        }
        System.out.println(Math.min(number, s.length() - number));
    }
}
