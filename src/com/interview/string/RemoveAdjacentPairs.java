package com.interview.string;

//ABCCBCBA -> ABBCBA -> ACBA

public class RemoveAdjacentPairs {

    public void removeAdjacentPairs(String s){
        StringBuffer sb = new StringBuffer(s);

        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i-1) == sb.charAt(i)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                if(sb.length() > 1)
                    removeAdjacentPairs(sb.toString());
            }
        }
        System.out.println(sb.toString());
        System.exit(1);
    }

    //ABCCBCBA -> ABBCBA -> ACBA
    //ABCCBCBA -> ACCCBCBA -> ACBCBCBA -> ACBABCBA

    public void removeAdjacentPairs_2(){
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
