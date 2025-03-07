package com.interview.systemDesign.LLD;

import java.util.TreeSet;

//Elevator direction - UP / DOWN / IDLE
//Move passenger from one floor to another floor
//Add or remove floors, as well elevators
//Elevator Car
    //No. of passengers
    //Max load
    //Max speed

//Non Functional Requirements
    //Less wait time
    //Low cost for running elevator
    //High throughput
    //High availability

// Algorithms

    // FCFS - poll each requests out of queue one by one move elevator according to each request, frequent change of direction of elevator, hence inefficient and long waiting time for users
    // SSTF - min distance of requested floor from the current floor of elevator, starvation of distant floor when maximum request keeps comes from nearly floors
    // Scan Algorithm - In this algorithm, elevator starts from one end of the disk and moves towards the other end, servicing requests in between one by one and reach the other end. Then the direction of the elevator is reversed and the process continues.
    // Look up Algorithm - In this algorithm, the elevator moves in a specific direction, but instead of going all the way to the end of the building before reversing direction like the SCAN algorithm, it reverses direction as soon as it reaches the last request in the current direction.

class Elevator {
    private Direction currentDirection = Direction.UP;
    private State currentState = State.IDLE;
    private int currentFloor = 0;

    private TreeSet<Request> currentJobs = new TreeSet<>();     // jobs which are being processed
    private TreeSet<Request> upPendingJobs = new TreeSet<>();       // up jobs which cannot be processed now so put in pending queue
    private TreeSet<Request> downPendingJobs = new TreeSet<>();     // down jobs which cannot be processed now so put in pending queue

    public void startElevator() {
        System.out.println("The Elevator has started functioning");
        while (true) {

            if (checkIfJob()) {

                if (currentDirection == Direction.UP) {
                    Request request = currentJobs.pollFirst();
                    processUpRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingDownJobsToCurrentJobs();
                    }
                }

                if (currentDirection == Direction.DOWN) {
                    Request request = currentJobs.pollLast();
                    processDownRequest(request);
                    if (currentJobs.isEmpty()) {
                        addPendingUpJobsToCurrentJobs();
                    }
                }
            }
        }
    }

    public boolean checkIfJob() {
        return currentJobs.isEmpty() ? false : true;
    }

    private void processUpRequest(Request request) {

        int startFloor = currentFloor;
        // The elevator is not on the floor where the person has requested it i.e. source floor. So first bring it there.
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                currentFloor = i;
            }
        }
        // The elevator is now on the floor where the person has requested it i.e. source floor. User can enter and go to the destination floor.
        System.out.println("Reached Source Floor--opening door");

        startFloor = currentFloor;

        for (int i = startFloor + 1; i <= request.getInternalRequest().getDestinationFloor(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We have reached floor -- " + i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }
    }

    private void processDownRequest(Request request) {

        int startFloor = currentFloor;
        if (startFloor < request.getExternalRequest().getSourceFloor()) {
            for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                currentFloor = i;
            }
        }

        System.out.println("Reached Source Floor--opening door");

        startFloor = currentFloor;

        for (int i = startFloor - 1; i >= request.getInternalRequest().getDestinationFloor(); i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We have reached floor -- " + i);
            currentFloor = i;
            if (checkIfNewJobCanBeProcessed(request)) {
                break;
            }
        }
    }

    private boolean checkIfNewJobCanBeProcessed(Request currentRequest) {
        if (checkIfJob()) {
            if (currentDirection == Direction.UP) {
                Request request = currentJobs.pollLast();
                if (request.getInternalRequest().getDestinationFloor() < currentRequest.getInternalRequest()
                        .getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);
            }

            if (currentDirection == Direction.DOWN) {
                Request request = currentJobs.pollFirst();
                if (request.getInternalRequest().getDestinationFloor() > currentRequest.getInternalRequest()
                        .getDestinationFloor()) {
                    currentJobs.add(request);
                    currentJobs.add(currentRequest);
                    return true;
                }
                currentJobs.add(request);
            }

        }
        return false;
    }

    private void addPendingDownJobsToCurrentJobs() {
        if (!downPendingJobs.isEmpty()) {
            System.out.println("Pick a pending down job and execute it by putting in current job");
            currentJobs = downPendingJobs;
            currentDirection = Direction.DOWN;
        } else {
            currentState = State.IDLE;
            System.out.println("The elevator is in Idle state");
        }
    }

    private void addPendingUpJobsToCurrentJobs() {
        if (!upPendingJobs.isEmpty()) {
            System.out.println("Pick a pending up job and execute it by putting in current job");

            currentJobs = upPendingJobs;
            currentDirection = Direction.UP;
        } else {
            currentState = State.IDLE;
            System.out.println("The elevator is in Idle state");
        }
    }

    public void addJob(Request request) {

        if(request.getExternalRequest() != null) {
            System.out.println("Got the request from floor " + request.getExternalRequest().getSourceFloor());
        } else {
            System.out.println("Got the request to floor " + request.getInternalRequest().getDestinationFloor());
        }

        if (currentState == State.IDLE) {
            currentState = State.MOVING;
            currentDirection = request.getExternalRequest().getDirectionToGo();
            currentJobs.add(request);
        } else if (currentState == State.MOVING) {
            addtoPendingJobs(request);
            currentJobs.add(request);
        }
    }

    public void addtoPendingJobs(Request request) {
        if (request.getExternalRequest().getDirectionToGo() == Direction.UP) {
            System.out.println("Add to pending up jobs");
            upPendingJobs.add(request);
        } else {
            System.out.println("Add to pending down jobs");
            downPendingJobs.add(request);
        }
    }
}

enum State {
    MOVING, IDLE
}

enum Direction {
    UP, DOWN
}

class Request implements Comparable<Request> {
    private InternalRequest internalRequest;
    private ExternalRequest externalRequest;

    public Request(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    public Request(ExternalRequest externalRequest) {
        this.externalRequest = externalRequest;
    }

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    public ExternalRequest getExternalRequest() {
        return externalRequest;
    }

    public void setExternalRequest(ExternalRequest externalRequest) {
        this.externalRequest = externalRequest;
    }

    @Override
    public int compareTo(Request req) {
        if (this.getInternalRequest() != null && this.getInternalRequest().getDestinationFloor() == req.getInternalRequest().getDestinationFloor())
            return 0;
        else if (this.getInternalRequest() != null && this.getInternalRequest().getDestinationFloor() > req.getInternalRequest().getDestinationFloor())
            return 1;
        else
            return -1;
    }
}

class ExternalRequest {

    private Direction directionToGo;
    private int sourceFloor;

    public ExternalRequest(Direction directionToGo, int sourceFloor) {
        this.directionToGo = directionToGo;
        this.sourceFloor = sourceFloor;
    }

    public Direction getDirectionToGo() {
        return directionToGo;
    }

    public void setDirectionToGo(Direction directionToGo) {
        this.directionToGo = directionToGo;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    @Override
    public String toString() {
        return " The Elevator has been requested on floor - " + sourceFloor + " and the person wants go in the - "
                + directionToGo;
    }

}

class InternalRequest {
    private int destinationFloor;

    public InternalRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    @Override
    public String toString() {
        return "The destinationFloor is - " + destinationFloor;
    }

}

public class ElevatorTest {

    public static void main(String args[]) {

        Elevator elevator = new Elevator();
        Thread t = new Thread(() -> elevator.startElevator());   // start elevator
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExternalRequest er = new ExternalRequest(Direction.UP, 0);
        Request request = new Request(er);
        elevator.addJob(request);

        InternalRequest ir = new InternalRequest(5);
        Request request2 = new Request(ir);
        elevator.addJob(request2);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}