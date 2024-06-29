package com.interview.greedy;

public class LemonadeChange {

    public static boolean test(){

        int[] bills = {5, 5, 5, 20, 5, 10, 10, 5};
        int N = 5;
        int five = 0,  ten = 0;

        for(int i=0; i<N; i++) {
            if(bills[i] == 5) {
                five++;
            } else if(bills[i] == 10) {
                if(five == 0)
                    return false;

                ten++;
                five--;
            } else {
                if((ten >= 1 && five >= 1)) {
                    ten--;
                    five--;
                    continue;
                } else if((ten ==0 && five >= 3)){
                    five = five - 3;
                }else
                    return false;
            }
        }
        return true;
    }
}
