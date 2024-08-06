package com.interview.systemDesign.DesignPattern.behavioural;

// The Strategy Design Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each
// algorithm, and makes them interchangeable. It allows the client to choose an algorithm at runtime without altering the client’s code.

// Step 1: Define the Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Step 2: Create ConcreteStrategy classes
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Step 3: Create the Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using Credit Card for payment
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        // Using PayPal for payment
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(150);
    }
}
