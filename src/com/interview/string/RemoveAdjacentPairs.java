package com.interview.string;

//ABCCBCBA -> ABBCBA -> ACBA

public class RemoveAdjacentPairs {

    //ABCCBCBA -> ABBCBA -> ACBA
    //ABCCBCBA -> ACCCBCBA -> ACBCBCBA -> ACBABCBA

    public void removeAdjacentPairs(){
        String s = "ABCCBCBA";
        char[] array = s.toCharArray();
        int j=0;
        for(int i=1; i<array.length; i++){
            while ((array[i] == array[j]) && (j >= 0)){
                i++;
                j--;
            }
            array[++j] = array[i];
        }
        for(int i=0; i<=j; i++)
            System.out.print(array[i]);
    }
}
