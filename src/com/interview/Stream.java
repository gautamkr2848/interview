package com.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public Map<String, Integer> sortByValue(Map<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        return hm;
    }

    public Map<String, Integer> sortByValue_2(Map<String, Integer> hm){
        return hm.entrySet().stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private void method1() {
        List<String> list = Arrays.asList("a", "b", "a");
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map.toString());
    }

    public static void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println(isEven.toString());
    }

    public static void main(String[] args) {
        whenApplySummarizing_thenGetBasicStats();
    }

    public static void whenApplySummarizing_thenGetBasicStats() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        DoubleSummaryStatistics stats = intList.stream()
                .collect(Collectors.summarizingDouble(x -> x));
        System.out.println(stats.toString());
    }
}
