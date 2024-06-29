package com.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    public static void nonRepeatingCharacter(){
        String s = "geeksforgeeks";

        s.chars().distinct().forEach(x -> System.out.print((char) x));
    }

    public static void main(String[] args) {
        nonRepeatingCharacter();
    }
}
