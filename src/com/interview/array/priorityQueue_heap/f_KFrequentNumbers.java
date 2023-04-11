package com.interview.array.priorityQueue_heap;

import java.util.*;
import java.util.stream.Collectors;

public class f_KFrequentNumbers {

    public void kFrequentNumbers(){

        int[] arr = {3, 1, 5, 4, 4, 5, 2, 6, 1, 5};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) ->
//                a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue()));

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.add(entry);

        for (int i = 0; i < k; i++)
            System.out.println(queue.poll().getKey());
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
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}