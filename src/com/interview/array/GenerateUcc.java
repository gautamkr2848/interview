package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateUcc {
    public void printAllKLength() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        int k = 2;
        int i=0;
        for(char c = 'A'; c <= 'Z' && i<26; ++c, i++)
            list.add(String.valueOf(c));

        int n = list.size();
        list1 = printAllKLengthRec(list, "", n, k, list1);
        list.clear();

        k = 6;
        for(int l=1; l<=9; l++)
            list.add(String.valueOf(l));

        n = list.size();
        list2 = printAllKLengthRec(list, "", n, k, list2);

        for(int l=0; l<list1.size(); l++){
            for(int j=0; j<list2.size(); j++){
                StringBuilder sb = new StringBuilder(list1.get(l));
                sb.append(list2.get(j));
                System.out.println(sb.toString());
            }
        }
    }

    private List<String> printAllKLengthRec(List<String> list, String prefix, int n, int k, List<String> resultList) {
        if (k == 0) {
            resultList.add(prefix);
            return resultList;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + list.get(i);
            printAllKLengthRec(list, newPrefix, n, k - 1, resultList);
        }
        return resultList;
    }
}
