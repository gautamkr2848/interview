package com.interview.math;

public class Power {

    public int power(int a, int b){
        if(b == 0)
            return 1;
        int temp = power(a, b/2);
        if(b % 2 == 0)
            return temp * temp;
        else {
            if(b > 0)
                return a * temp * temp;
            else
                return (temp * temp) / a;
        }
    }

    public void palindromepair() {

        String[] arr = {"y", "v"};
        int n = arr.length;

        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                StringBuilder sb = new StringBuilder(arr[i]);
                sb.append(arr[j]);
                if(isPelindrome(sb.toString())){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

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
        int a = 3, b = 4;
        int result = 1;
        if(b == 0)
            System.out.println("1");

        for(int i=1; i<=b; i++){
            result = result * a;
        }
        System.out.println(result);
    }

}
