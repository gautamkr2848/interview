package com.interview;

import com.interview.array.StockBuySell;
import com.interview.dynamic.LCS.k_LongestSubStringWithNonRepeatedChar;
import com.interview.dynamic.MCM.a_MatrixChainMultiplication;
import com.interview.list.Node;
import com.interview.list.DetectAndRemoveLoop;
import com.interview.list.RemoveDuplicates;
import com.interview.list.SwapKthBeginingEnd;
import com.interview.matrix.MaxSumRectangle;
import com.interview.recursion.PalindromePartioning;
import com.interview.stack.WaterTapping;
import com.interview.string.excel.ColumnNumberToName;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        ColumnNumberToName c = new ColumnNumberToName();
        c.columnNumberToName();
    }

    private void excelCode(){
        String path = "/Users/gautam.k/Desktop/Data1.csv";
        String line = "";

        Boolean flag = Boolean.TRUE;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            FileWriter writer = new FileWriter("/Users/gautam.k/Desktop/Data2.csv");
            BufferedWriter bwr = new BufferedWriter(writer);

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if(flag){
                    bwr.write(values[0] + ';');
                    bwr.write(values[1] + ';');
                    bwr.write(values[2] + ';');
                    bwr.write(values[3] + ';');
                    bwr.write(values[4] + ';');
                    bwr.write("\n");
                    flag = Boolean.FALSE;

                } else if(values[2].equalsIgnoreCase("ca3c619f-f5ca-43ab-bfbb-e65f6d99015c")) {
                    bwr.write(values[0] + ';');
                    bwr.write(values[1] + ';');
                    bwr.write(values[2] + ';');
                    bwr.write(values[3] + ';');
                    bwr.write(values[4] + ';');
                    bwr.write("\n");
                }

            }
            bwr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
