package com.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

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
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }

    private void method1() {
        List<String> list = Arrays.asList("a", "b", "a");
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map.toString());
    }

    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
    }

    public void whenApplySummarizing_thenGetBasicStats() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        DoubleSummaryStatistics stats = intList.stream()
                .collect(Collectors.summarizingDouble(x -> x));
    }
}
