package com.interview.miscellaneous;

//Input: money = 16, price = 2, wrap = 2
//Output:   15
//Price of a chocolate is 2. You can buy 8 chocolates from
//amount 16. You can return 8 wrappers back and get 4 more
//chocolates. Then you can return 4 wrappers and get 2 more
//chocolates. Finally you can return 2 wrappers to get 1
//more chocolate.
//
//Input:   money = 15, price = 1, wrap = 3
//Output:   22
//We buy and eat 15 chocolates
//We return 15 wrappers and get 5 more chocolates.
//We return 3 wrappers, get 1 chocolate and eat it
//(keep 2 wrappers). Now we have 3 wrappers. Return
//3 and get 1 more chocolate.
//So total chocolates = 15 + 5 + 1 + 1
//
//Input:  money = 20, price = 3, wrap = 5
//Output:   7

public class ChoclateWrapper {

    public static int countMaxChoco(int money, int price, int wrap) {
        if (money < price)
            return 0;

        int choc = money / price;
        choc = choc + (choc - 1) / (wrap - 1);      // Now just add number of chocolates with the chocolates gained by wrapprices
        return choc;
    }

    // Another Option
    public static int countMaxChoco_2(int money, int price, int wrap) {

        int choc = money/price;
        return choc + countRec(choc, wrap);
    }

    public static int countRec(int choc, int wrap) {

        if (choc < wrap)
            return 0;

        int newChoc = choc / wrap;
        return newChoc + countRec(newChoc + choc % wrap, wrap);
    }

}
