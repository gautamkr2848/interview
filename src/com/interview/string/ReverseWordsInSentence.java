package com.interview.string;

public class ReverseWordsInSentence {

    public void reverseWordsInSentence(){
        String s = "Beyond Square Solutions";
        String[] array = s.split("\\s");

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<array.length; i++){
            String temp = reverseWord(array[i]);
            array[i] = temp;
            sb.append(array[i]+" ");
        }
        System.out.println(sb.toString());
    }

    String reverseWord (String str){
        StringBuffer sb = new StringBuffer(str);
        int n = sb.length();
        int i=0;
        while(i<n){
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(n-1));
            sb.setCharAt(n-1, c);
            i++;
            n--;
        }
        return sb.toString();
    }
}
