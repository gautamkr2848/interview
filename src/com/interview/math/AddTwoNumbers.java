package com.interview.math;

import java.math.BigInteger;

public class AddTwoNumbers {

    public void add(){
        String str="7777555511111111";
        String str1="3332222221111";

        BigInteger a=new BigInteger(str); // creating obj of biginteger and pass str in it
        BigInteger b=new BigInteger(str1); // creating obj of biginteger and pass str1 in it

        System.out.println(a.add(b));
    }

    public String add_2(String str1, String str2) {
        // Before proceeding further, make sure length of str2 is larger.
        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        String str = "";
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();
        int carry = 0;

        for (int i = 0; i < n1; i++){
            // Do school mathematics, compute sum of current digits and carry
            int sum = ((int)(str1.charAt(i) - '0') + (int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++) {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0)
            str += (char)(carry + '0');

        return new StringBuilder(str).reverse().toString();
    }
}
