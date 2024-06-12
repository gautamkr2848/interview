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



// 2nd Approach

    Boolean isEven = Boolean.FALSE;

    private void printOdd_2(){
        while (start <= N){
            if(!isEven)
                if(start % 2 != 0) {
                    System.out.println("Thread one "+ start++ + " ");
                    isEven = !isEven;
                }
        }
    }

    private void printEven_2(){
        while (start <= N){
            if(isEven)
                if(start % 2 == 0) {
                    System.out.println("Thread two "+ start++ + " ");
                    isEven = !isEven;
                }
        }
    }
}

class PrintSequence implements Runnable {

    public int PRINT_NUMBERS_UPTO = 10;
    static int number = 1;
    int remainder;
    static Object lock = new Object();

    PrintSequence(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintSequence runnable1=new PrintSequence(1);
        PrintSequence runnable2=new PrintSequence(2);
        PrintSequence runnable3=new PrintSequence(0);

        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");
        Thread t3=new Thread(runnable3,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
