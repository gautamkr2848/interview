package com.interview.string;

//int decimal=Integer.parseInt(binaryString,2);
//Integer.toBinaryString(3);

public class BinaryToNumber {

    public void binaryToNumber(){
        String s = "1101";
        int n = 0;
        int length = s.length();
        for(int i = length - 1, count =0; i>=0; i--){
            n = n + Character.getNumericValue(s.charAt(i)) * (int)Math.pow(2, count++);
        }
        System.out.println(n);
    }
}
