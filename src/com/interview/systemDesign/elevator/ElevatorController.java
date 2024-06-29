package com.interview.systemDesign.elevator;

import com.interview.systemDesign.elevator.enums.Direction;
import com.interview.systemDesign.elevator.model.ElevatorCar;
import com.interview.systemDesign.elevator.model.PendingRequests;

public class ElevatorController {

    private int id;
    private ElevatorCar elevatorCar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public ElevatorController(int id) {
        this.id= id;
        elevatorCar= new ElevatorCar(id);
    }

    public void acceptRequest(int floor, Direction dir) {
        ElevatorSystem.elevatorControlStrategy.getPendingRequestList().add(new PendingRequests(floor, dir));

        controlCar();
    }
    private void controlCar() {
        ElevatorSystem.elevatorControlStrategy.moveElevator(this);
        System.out.println("Elevator moving...");
    }

}

