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
