package com.interview.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IsPrime {

    public String isPrime(int n){
        for(int i=2; i<=Math.sqrt(new Double(n)); i++) {
            if (n % i == 0) {
                return "Not a prime";
            }
        }
        return "Is a prime";
    }

    //Using of Sieve Of Eratosthenes
    //If a number is prime then all the multipliers of that number will not be prime
    public void findAllPrime(){
        int n = 100;
        int[] primes = new int[n];
        for(int i=0; i<n; i++)
            primes[i] = 1;

        primes[0] = 0;
        primes[1] = 0;

        for(int i=2; i <= Math.sqrt(new Double(n)); i++){
            if(primes[i] == 1){
                for(int j=2; i*j <= n; j++){
                    primes[i*j] = 0;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(primes[i] == 0)
                System.out.println(i + " ");
        }
    }

    //Time Complexity = O(nloglog(n))

    //Find all factors
    //36 => {1, 2, 3, 4, 6, 9, 12, 18, 36}
    //if a < b, a < Math.sqrt(n)
    //          b > Math.sqrt(n)
    //if a > b, a > Math.sqrt(n)
    //          b < Math.sqrt(n)
    public void findAllFactors(int n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(n);

        for(int i=0; i<=Math.sqrt(new Double(n)); i++){
            if(n % i == 0){
                list.add(i);
                if(1 != Math.sqrt(new Double(n)))
                    list.add(n / i);
            }
        }

        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }


    //Prime Factorization
    //44 => 2 * 2 * 11
    public void primeFactorization(int n){
        for(int i=0; i<=Math.sqrt(new Double(n)); i++){
            if(n % i == 0){
                int count = 0;
                while(n % i == 0){
                    n = n / i;
                    count++;
                }
                System.out.println(i + " " + count);
            }
        }

        if(n != 1)
            System.out.println(n + " " + 1);
    }
}
