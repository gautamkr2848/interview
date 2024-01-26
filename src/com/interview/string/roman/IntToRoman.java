package com.interview.string.roman;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public void intToRoman(){

        int num = 1457;
        System.out.println("Integer: " + num);
        String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands = {"","M","MM","MMM"};

        System.out.println(thousands[(num % 10000) / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                units[(num % 10) / 1]);
    }

    public void intToRoman_2(){

        int num = 1457;
        System.out.println("Integer: " + num);
        String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands = {"","M","MM","MMM"};

        System.out.println(thousands[(num % 10000) / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                units[(num % 10) / 1]);
    }
}
