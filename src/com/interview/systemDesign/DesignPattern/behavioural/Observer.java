package com.interview.systemDesign.DesignPattern.behavioural;

// Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, its
// depenedent objects are to be modified automatically. Observer pattern falls under behavioral pattern category.

//Observer pattern uses three actor classes. Subject, Observer and Client.

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

/* - o/p
First state change: 15
Hex String: F
Octal String: 17
Binary String: 1111
Second state change: 10
Hex String: A
Octal String: 12
Binary String: 1010
 */

class Subject {

    private List<ObserverAbstract> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(ObserverAbstract observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (ObserverAbstract observer : observers) {
            observer.update();
        }
    }
}

abstract class ObserverAbstract {
    protected Subject subject;
    public abstract void update();
}

class BinaryObserver extends ObserverAbstract{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}

class OctalObserver extends ObserverAbstract{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}

class HexaObserver extends ObserverAbstract{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
