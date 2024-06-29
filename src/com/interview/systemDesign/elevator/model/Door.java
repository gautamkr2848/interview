package com.interview.systemDesign.elevator.model;

public class Door {

    public void open(int elevatorId) {
        System.out.println("Door opens for elevator "+ elevatorId);
    }

    public void close(int elevatorId) {
        System.out.println("Door closes for elevator "+ elevatorId);
    }

}
