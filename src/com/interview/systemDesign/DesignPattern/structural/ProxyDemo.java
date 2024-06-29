
package com.interview.systemDesign.DesignPattern.structural;

// The Proxy design pattern is a structural pattern that provides a surrogate or placeholder for another object to
// control access to it. This pattern can be used for various purposes such as controlling access, logging etc.

// Subject Interface
interface Subject {
    void request();
}

// RealSubject Class
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

// Proxy Class
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        System.out.println("Proxy: Logging access to RealSubject.");
        realSubject.request();
    }
}

// Usage
public class ProxyDemo {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
        // Output:
        // Proxy: Logging access to RealSubject.
        // RealSubject: Handling request.
    }
}