package com.interview.miscellaneous;

public class CountPossibleDecodings {

    public void countPossibleDecodings(){
        int digits[] = {'1','2','3','4'};
        int count[] = new int[digits.length + 1];
        count[0] = 1;
        count[1] = 1;
        if(digits[0]=='0') {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= digits.length; i++){
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller than 2 and last digit is smaller
            // than 7, then last two digits form a valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] = count[i] + count[i - 2];
        }
        System.out.println(count[digits.length]);
        return;
    }
}
