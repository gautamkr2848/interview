package com.interview.systemDesign.DesignPattern.behavioural;

// The Observer pattern is a behavioral design pattern that allows an object (the "subject") to notify a list of
// dependent objects (the "observers") about state changes, usually by calling one of their methods. This pattern is
// useful when you want to create a one-to-many dependency between objects, so that when one object changes state,
// all its dependents are notified and updated automatically.

// Components:
// Subject: The object that maintains a list of observers and sends notifications.
// Observer: The object that gets notified of changes in the subject.

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Subject
class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Usage
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.notifyObservers("Hello Observers!");
    }

    // Output:
    // Observer 1 received message: Hello Observers!
    // Observer 2 received message: Hello Observers!
}
