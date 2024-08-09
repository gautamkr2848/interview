package com.interview.stack;

import java.util.Stack;

public class QueueUsingStack {

     Stack<Integer> s1 = new Stack<Integer>();
     Stack<Integer> s2 = new Stack<Integer>();

     // By making enQueue operation costly
     void enQueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue an item from the queue
     int deQueue() {
        // if first stack is empty
        if (s1.isEmpty()) {
            return -1;
        }

        return s1.pop();
    }
}

