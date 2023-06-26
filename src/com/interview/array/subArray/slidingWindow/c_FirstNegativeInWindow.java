package com.interview.array.subArray.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class c_FirstNegativeInWindow {

    public void firstNegativeInWindow(){
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        for(int i = 0; i <= arr.length-k; i++) {
            int tmp = arr[i];
            if(arr[i] < 0) {
                System.out.print(tmp + " ");
                continue;
            }
            int j;
            for(j=1; j<k; j++){
                if (arr[i+j] < 0){
                    System.out.print(arr[i+j]);
                    break;
                }
            }
            if(j == k)
                System.out.print("0 ");
        }
    }

    public void printFirstNegativeInteger() {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        int i;
        for (i = 0; i < k; i++)
            if (arr[i] < 0)
                deque.addLast(i);

        for (; i < arr.length; i++) {
            if(deque.peek() != null)
                result.add(arr[deque.peek()]);

            while (!deque.isEmpty() && deque.peek() <= i - k)       // Remove the elements which are out of this window
                deque.removeFirst();

            while (!deque.isEmpty() && arr[deque.peekLast()] >= 0)      // remove useless elements
                deque.removeLast();

            deque.addLast(i);
        }

        if(arr[deque.peek()] >= 0)
            result.add(0);

        System.out.println(result.toString());
    }
}
