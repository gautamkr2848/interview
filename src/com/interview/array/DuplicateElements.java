package com.interview.array;

public class DuplicateElements {

    public void duplicateElements(int[] a){
        for(int i=0; i<a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.print(Math.abs(a[i])+" ");
            }
        }
    }
}
