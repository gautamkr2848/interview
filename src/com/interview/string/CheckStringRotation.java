package com.interview.string;

public class CheckStringRotation {

    public Boolean stringRotation(){
        String s1 = "apple";
        String s2 = "pleap";
        Boolean result  = false;

        char c = s1.charAt(0);
        int[] number = new int[s1.length()];
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i) == c){
                number[i] = i;
            }
        }

        for(int j=0; j<number.length; j++){
            int k = number[j];
            for(int i=0; i<s1.length() && number[j]>0; i++){
                if(s1.charAt(i) != s2.charAt(k)) {
                    return false;
                }
                if(k == s2.length()-1)
                    k=0;
                else
                    k++;
            }
        }
        return null;
    }
}
