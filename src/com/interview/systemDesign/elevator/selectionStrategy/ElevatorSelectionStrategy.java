package com.interview.systemDesign.elevator.selectionStrategy;

import com.interview.systemDesign.elevator.enums.Direction;
import com.interview.systemDesign.elevator.ElevatorController;
import com.interview.systemDesign.elevator.ElevatorSystem;

import java.util.List;

public class ElevatorSelectionStrategy {

    protected List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

    public int selectElevator(int floor, Direction dir) {
        return 0;
    }
}

