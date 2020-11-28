package com.interview;

/*
If a thread is holding a resource A and waiting for resource B. And Another
thread is holding a resource B and waiting for resource A.

We can prevent Deadlock by eliminating any of the four conditions.
    1. Mutual Excecution
    2. Hold and Wait
    3. No preemption
    4. Circular wait

Deadlock Avoidance  => Banker's Algorithm
    Bankers’s Algorithm is resource allocation and deadlock avoidance algorithm
    which test all the request made by processes for resources, it checks for the safe state
    Inputs to Banker’s Algorithm:
        1. Max need of resources by each process.
        2. Currently allocated resources by each process.
        3. Max free available resources in the system.
*/


public class Deadlock {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public void deadlock() {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock2) {      //change to Lock1
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (Lock1) {      //change to Lock2
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
