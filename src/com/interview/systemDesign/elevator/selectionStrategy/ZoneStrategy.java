package com.interview.systemDesign.elevator.selectionStrategy;

import com.interview.systemDesign.elevator.enums.Direction;
import com.interview.systemDesign.elevator.ElevatorController;

import java.util.concurrent.ThreadLocalRandom;

public class ZoneStrategy extends ElevatorSelectionStrategy {

    @Override
    public int selectElevator(int floor, Direction dir) {
        for(ElevatorController eController: elevatorControllerList)
        {
            //assign elevators according to zones in building
            //out of these elevators select the elevator which is going in the same direction or is idle
        }
        return ThreadLocalRandom.current().nextInt(1, elevatorControllerList.size());
    }
}

