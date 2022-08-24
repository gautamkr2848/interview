package com.interview.array.subArray.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInWindow {

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

        int i;
        for (i = 0; i < k; i++)
            if (arr[i] < 0)
                deque.addLast(i);

        for (; i < arr.length; i++) {
            System.out.print(arr[deque.peek()] + " ");
            while (!deque.isEmpty() && deque.peek() <= i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && arr[deque.peekLast()] >= 0)
                deque.removeLast();

            deque.addLast(i);
        }
        if(arr[deque.peek()] >=0)
            System.out.print("0 ");
    }
}
