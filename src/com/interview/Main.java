package com.interview;

import com.interview.backtracking.GenerateParenthesis;
import com.interview.recursion.PalindromePartioning;
import com.interview.stack.LongestValidSubString;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String mailSubject = " Josh Alert! Notification Job for failed due to Request Timeout : 408, At : " + LocalDateTime.now().format(formatter);
        System.out.println(mailSubject);


    }

    public Map<String, Integer> sortByValue(Map<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

        HashMap<String, Integer> temp = new HashMap<>();
        for (Map.Entry<String, Integer> aa : list)
            temp.put(aa.getKey(), aa.getValue());

        return temp;
    }

    public Map<String, Integer> sortByValue_2(Map<String, Integer> hm){
        return hm.entrySet().stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    private void method1() {
        List<String> list = Arrays.asList("a", "b", "a");
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map.toString());
    }

    private static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
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
