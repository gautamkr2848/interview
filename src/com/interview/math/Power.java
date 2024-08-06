package com.interview.math;

public class Power {



    public Boolean isPelindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        String rev=sb.toString();
        if(str.equals(rev)){
            return true;
        }else{
            return false;
        }
    }

    public void power_2(){
        int a = 81, b = 4;
        int result = 1;
        if(b == 0)
            System.out.println("1");

        for(int i=1; i<=b; i++){
            result = result * a;
        }
        System.out.println(result);
    }

}
