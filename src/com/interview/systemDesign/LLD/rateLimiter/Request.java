package com.interview.systemDesign.LLD.rateLimiter;

import java.time.Instant;
import java.time.LocalDateTime;

public class Request {

    private LocalDateTime timestamp;
    private Integer count;

    public Request(LocalDateTime timestamp, Integer count) {
        this.timestamp = timestamp;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
