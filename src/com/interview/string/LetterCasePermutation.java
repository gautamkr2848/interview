package com.interview.string;

public class LetterCasePermutation {

    public void permutations(){
        String s = "a1b2";
        char [] str = s.toCharArray();
        printPermutation(str,0);
    }

    private void printPermutation(char [] str, int pos) {
        if(pos == str.length) {
            for(int i=0;i<pos;i++)
                System.out.print(str[i]);
            System.out.print(" ");
            return;
        }

        if (str[pos] >= '0' && str[pos] <= '9') {
            printPermutation(str, pos + 1);
            return;
        }

        str[pos] = Character.toLowerCase(str[pos]);
        printPermutation(str, pos + 1);

        str[pos] = Character.toUpperCase(str[pos]);
        printPermutation(str, pos + 1);
    }
}
