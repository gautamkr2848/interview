package com.interview.miscellaneous;

import java.io.*;

public class ReadCSV {

    private static void excelCode(){
        String path = "/Users/gautam.k/Downloads/Data1.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            FileWriter writer = new FileWriter("/Users/gautam.k/Desktop/Data2.csv");
            BufferedWriter bwr = new BufferedWriter(writer);

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");

                bwr.write(values[0] + ';');
                bwr.write(values[1] + ';');
                bwr.write(values[2] + ';');
                bwr.write(values[3] + ';');
                bwr.write(values[4] + ';');
                bwr.write("\n");
            }
            bwr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
