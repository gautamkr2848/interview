package com.interview.string.roman;

public class IntToRoman {

    public static void main(String[] args){

        String[] units = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"M", "MM", "MMM"};

        int n = 4;
        int power = String.valueOf(n).length()-1;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int div = (int) (n / (Math.pow(10, power)));
            int rem = (int) (n % ((Math.pow(10, power))));

            switch (power) {
                case 3 :
                    sb.append(thousands[div-1]);
                    break;
                case 2 :
                    sb.append(hundreds[div-1]);
                    break;
                case 1 :
                    sb.append(tens[div-1]);
                    break;
                default : sb.append(units[div-1]);
            }

            n = rem;
            power--;
        }

        System.out.println(sb.toString());
    }
}
