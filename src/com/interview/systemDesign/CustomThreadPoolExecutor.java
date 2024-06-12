package com.interview.systemDesign;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*

Thread pool executor requires a Queue for holding tasks and a collection of Worker Threads
that will pick up tasks from the working queue and start running them. It is a typical
Producer Consumer Problem statement.

                            Thread Pool Executor
                ----------------------------------------------
Task producer   |    =>  Task Queue  =>  Worker Threads  =>  |  Task Results
                ----------------------------------------------

LinkedBlockingQueue
    A bounded blocking queue based on linked nodes. This queue stores elements in FIFO order.
    It is thread-safe in nature and acts as a temporary storage of runnable tasks.

    A blocking queue indicates that the queue blocks the accessing thread if it is full (when the queue is bounded) or
    becomes empty. If the queue is full, then adding a new element will block the accessing thread unless there is space
    available for the new element.

*/

public class CustomThreadPoolExecutor {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numThreads) {
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i = 0;
        for (Thread t : workerThreads) {
            t = new Worker("Custom Pool Thread " + ++i);
            t.start();
        }
    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(10);
        threadPoolExecutor.addTask(() -> System.out.println("First print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
    }
}
