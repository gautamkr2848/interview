package com.interview;

import com.interview.array.RemoveElement;
import com.interview.graph.DFS.e_CountIsLand;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] people = {4, 1, 3, 5};
        int limit = 5;

        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;
        int boatCount = 0;

        while(start <= end) {
            boatCount++;
            if(people[start] + people[end] <= limit)
                start++;

            end--;
        }
        System.out.println(boatCount);
    }

    static int ROW=4, COL=2;
    private static int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];
        int count = 0;

        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    count++;
                }
        return count;
    }

    private static void DFS(int M[][], int row, int col, boolean visited[][]) {
        int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            Boolean isSafe = (row + rowNbr[k] >= 0) && (row + rowNbr[k] < ROW) && (col + colNbr[k] >= 0) && (col + colNbr[k] < COL) && M[row + rowNbr[k]][col + colNbr[k]] == 1 && !visited[row + rowNbr[k]][col + colNbr[k]];
            if (isSafe)
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
        }
    }

    private static void excelCode(){
        String path = "/Users/gautam.k/Downloads/Data1.csv";
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
