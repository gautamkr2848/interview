package com.interview.recursion;

public class StringPermutation {

    public void stringPermutation(String str, int l, int r){

        if(l==r) System.out.println(str);
        else {
            for(int i=l; i<=r; i++){
                str = swap(str, l, i);
                stringPermutation(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    String swap (String str, int l, int r) {
        StringBuffer sb = new StringBuffer(str);

        char temp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, temp);

        return sb.toString();
    }
}
