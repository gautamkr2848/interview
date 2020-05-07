package com.interview.string;

public class BinaryToNumber {

    public void binaryToNumber(){
        String s = "1101";
        int n = 0;;
        int length = s.length();
        int count = 0;
        for(int i = length - 1; i>=0; i--){
            n = n + Character.getNumericValue(s.charAt(i)) * (int)Math.pow(2, count++);
        }
        System.out.println(n);
    }
}
