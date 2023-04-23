package com.interview;

import com.interview.array.MaxJminusI;
import com.interview.greedy.ActivitySelection;
import com.interview.string.SubdomainCount;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SubdomainCount s = new SubdomainCount();
        s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }

    private static String maxSum(String w,char x[],int b[], int n){
        int maxSum = 0, sum = 0;
        String ans = "", res = "";
        for(int i=0; i<w.length(); i++){
            sum = sum + ascii(w.charAt(i), x, b);
            ans = ans + w.charAt(i);
            if(sum > maxSum){
                maxSum = sum;
                res = ans;
            } else if(sum < 0){
                sum = 0;
                ans = "";
            }
        }
        return res;
    }

    private static int ascii(char c, char[] x, int[] b) {
        for(int i=0; i<b.length; i++){
            if(x[i] == c)
                return b[i];
        }
        return (int) c;
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

                } else if (values[2].equalsIgnoreCase("ca3c619f-f5ca-43ab-bfbb-e65f6d99015c")) {
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
