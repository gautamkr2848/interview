package com.interview.excel;

public class ColumnNumberToName {

    private void columnNumberToName(){
        int n = 28;
        StringBuilder columnName = new StringBuilder();

        while (n > 0) {
            int rem = n % 26;

            if (rem == 0) {
                columnName.append("Z");
                n = (n / 26) - 1;
            } else {
                columnName.append((char)((rem - 1) + 'A'));
                n = n / 26;
            }
        }
        System.out.println(columnName.reverse().toString());
    }
}
