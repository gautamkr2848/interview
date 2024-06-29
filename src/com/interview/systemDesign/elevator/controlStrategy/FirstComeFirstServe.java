package com.interview.systemDesign.elevator.controlStrategy;

import com.interview.systemDesign.elevator.ElevatorController;

public class FirstComeFirstServe extends ElevatorControlStrategy {

    @Override
    public void moveElevator(ElevatorController elevatorController) {
        //poll each requests out of queue one by one
        //move elevator according to each request
        //Disadvantage: frequent change of direction of elevator, hence inefficient and
        // long waiting time for users

    }
}

