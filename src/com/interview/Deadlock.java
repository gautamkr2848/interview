package com.interview;

/*
If a thread is holding a resource A and waiting for resource B. And Another
thread is holding a resource B and waiting for resource A.

We can prevent Deadlock by eliminating these four conditions.
    1. Mutual Excecution
        One resource should be used by only one process at a time.
    2. Hold and Wait
        Ensure that none of the processes are holding a resource and waiting for another
    3. No preemption
        Once a process started, then don't stop it in middle. A resource cannot be taken from
        a process unless the process releases the resource.
    4. Circular wait
        A set of processes are waiting for each other in circular form

Deadlock Avoidance  => Banker's Algorithm
    Bankers’s Algorithm is resource allocation and deadlock avoidance algorithm
    which test all the request made by processes for resources, it checks for the safe state
    Inputs to Banker’s Algorithm:
        1. Max need of resources by each process.
        2. Currently, allocated resources by each process.
        3. Max free available resources in the system.

    The request will only be granted under the below condition:
        1. If the request made by the process is less than equal to max need to that process.
        2. If the request made by the process is less than equal to the freely available resource
           in the system.

    Total resources in system:              Available system resources are:
        A B C D                                     A B C D
        6 5 7 6                                     3 1 1 2

    Processes (currently allocated resources):
        A B C D
    P1  1 2 2 1
    P2  1 0 3 3
    P3  1 2 1 0

    Processes (maximum resources):          Need = maximum resources - currently allocated resources.
                                            Processes (need resources):
        A B C D                                     A B C D
    P1  3 3 2 2                                 P1  2 1 0 1
    P2  1 2 3 4                                 P2  0 2 0 1
    P3  1 3 5 0                                 P3  0 1 4 0

*/


public class Deadlock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public Deadlock() {
        Thread t1 = new Thread(() -> method1());
        Thread t2 = new Thread(() -> method2());
        t1.start();
        t2.start();
    }

    private void method1(){
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }

    private void method2(){
        synchronized (lock2) {      //change to Lock1
            System.out.println("Thread 2: Holding lock 2...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (lock1) {      //change to Lock2
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }
}
