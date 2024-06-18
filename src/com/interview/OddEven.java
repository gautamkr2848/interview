package com.interview;

public class OddEven {

    static int start = 1;
    static int N = 10;
    public void printOddEven() {
        Thread oddThread = new Thread(() -> printOdd());
        Thread evenThread = new Thread(() -> printEven());

        oddThread.start();
        evenThread.start();
    }

    public void printOdd(){

        synchronized(this) {
            while (start < N) {
                while (start % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(start++ + " ");
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this) {
            while (start < N) {
                while (start % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(start++ + " ");
                notify();
            }
        }
    }
}

class Test{
    static int start = 0;
    static int N = 8;
    public void printNumber(int threadId, int numberOfThreads) {
        synchronized (this) {
            while(start < N) {
                while (start % numberOfThreads != threadId) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread " + threadId + " : " + start++);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        Thread t1 = new Thread(() -> t.printNumber(0, 3));
        Thread t2 = new Thread(() -> t.printNumber(1, 3));
        Thread t3 = new Thread(() -> t.printNumber(2, 3));

        t1.start();
        t2.start();
        t3.start();
    }
}