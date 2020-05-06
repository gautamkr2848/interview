package com.interview.string;

public class StringToInt {

    public void stringToInt(){
        String s = "123";
        int length = s.length();
        Integer number = 0;
        int i=0;
        while(i < length){
            number = number * 10 + Character.getNumericValue(s.charAt(i));
            i++;
        }
        System.out.println(number);
    }
}
