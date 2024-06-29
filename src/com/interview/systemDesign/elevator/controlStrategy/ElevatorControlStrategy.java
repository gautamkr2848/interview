package com.interview.systemDesign.elevator.controlStrategy;

import com.interview.systemDesign.elevator.ElevatorController;
import com.interview.systemDesign.elevator.ElevatorSystem;
import com.interview.systemDesign.elevator.model.PendingRequests;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class ElevatorControlStrategy {

    //queue storing pending requests in form of
    private Queue<PendingRequests> pendingRequestList= new LinkedList<PendingRequests>();
    private List<ElevatorController> elevatorControllerList = ElevatorSystem.INSTANCE.getElevatorControllerList();

    public abstract void moveElevator(ElevatorController elevatorController);

    public Queue<PendingRequests> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(Queue<PendingRequests> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }
}

