package com.interview.systemDesign.rateLimiter;

import java.time.Instant;
import java.time.LocalDateTime;

public class RateLimiterService {

    public static void main(String[] args) throws InterruptedException {

        int limit = 1; // 5 requests per minute
        RateLimit rateLimit = new RateLimit(limit);
        Thread t1 = new Thread(() -> processRequest("UserA"));
        Thread t3 = new Thread(() -> processRequest("UserA"));
        Thread t2 = new Thread(() -> processRequest("UserB"));
        t1.start();
        t2.start();
        t3.start();
    }

    private static void processRequest(String user){
        RateLimit rateLimit = new RateLimit();
        rateLimit.hit(user, LocalDateTime.now());
    }

}
