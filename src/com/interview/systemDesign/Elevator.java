//package com.interview.systemDesign;
//
//import java.util.PriorityQueue;
//
//public class Elevator {
//
//    private int currentFloor;
//    private Direction direction;
//    private PriorityQueue<Request> upQueue;
//    private PriorityQueue<Request> downQueue;
//
//    public Elevator(int currentFloor) {
//        this.currentFloor = currentFloor;
//        this.direction = Direction.IDLE;
//        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);       // use default, which is a min heap
//        downQueue =  new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);        // use a max heap
//    }
//
//    public void sendUpRequest(Request upRequest) {
//        // If the request is sent from out side of the elevator,
//        // we need to stop at the current floor of the requester
//        // to pick him up, and then go the the desired floor.
//        if (upRequest.requestType == RequestType.OUTSIDE_ELEVATOR) {
//            // Go pick up the requester who is outside of the elevator
//            upQueue.offer(new Request(upRequest.currentFloor,
//                    upRequest.currentFloor,
//                    Direction.UP,
//                    RequestType.OUTSIDE_ELEVATOR));
//
//            System.out.println("Append up request going to floor " + upRequest.currentFloor + ".");
//        }
//
//        // Go to the desired floor
//        upQueue.offer(upRequest);
//
//        System.out.println("Append up request going to floor " + upRequest.desiredFloor + ".");
//    }
//
//    public void sendDownRequest(Request downRequest) {
//        // Similar to the sendUpRequest logic
//        if (downRequest.requestType == RequestType.OUTSIDE_ELEVATOR) {
//            downQueue.offer(new Request(downRequest.currentFloor,
//                    downRequest.currentFloor,
//                    Direction.DOWN,
//                    RequestType.OUTSIDE_ELEVATOR));
//
//            System.out.println("Append down request going to floor " + downRequest.currentFloor + ".");
//        }
//
//        // Go to the desired floor
//        downQueue.offer(downRequest);
//
//        System.out.println("Append down request going to floor " + downRequest.desiredFloor + ".");
//    }
//
//    public void run() {
//        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
//            processRequests();
//        }
//
//        System.out.println("Finished all requests.");
//        this.direction = Direction.IDLE;
//    }
//
//    private void processRequests() {
//        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
//            processUpRequest();
//            processDownRequest();
//        } else {
//            processDownRequest();
//            processUpRequest();
//        }
//    }
//
//    private void processUpRequest() {
//        while (!upQueue.isEmpty()) {
//            Request upRequest = upQueue.poll();
//            // Communicate with hardware
//            this.currentFloor = upRequest.desiredFloor;
//            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
//        }
//        if (!downQueue.isEmpty()) {
//            this.direction = Direction.DOWN;
//        } else {
//            this.direction = Direction.IDLE;
//        }
//    }
//
//    private void processDownRequest() {
//        while (!downQueue.isEmpty()) {
//            Request downRequest = downQueue.poll();
//            // Communicate with hardware
//            this.currentFloor = downRequest.desiredFloor;
//            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
//        }
//        if (!upQueue.isEmpty()) {
//            this.direction = Direction.UP;
//        } else {
//            this.direction = Direction.IDLE;
//        }
//    }
//
//    public static void main(String[] args) {
//        Elevator elevator = new Elevator(0);
//
//        Request downRequest3 = new Request(4,  Direction.DOWN, RequestType.OUTSIDE_ELEVATOR);
//        Request upRequest1 = new Request(elevator.currentFloor, 5, Direction.UP, RequestType.INSIDE_ELEVATOR);
//        Request upRequest2 = new Request(elevator.currentFloor, 3, Direction.UP, RequestType.INSIDE_ELEVATOR);
//
//        Request downRequest1 = new Request(elevator.currentFloor, 1, Direction.DOWN, RequestType.INSIDE_ELEVATOR);
//        Request downRequest2 = new Request(elevator.currentFloor, 2, Direction.DOWN, RequestType.INSIDE_ELEVATOR);
//
//        // Two people inside of the elevator pressed button to go up to floor 5 and 3.
//        elevator.sendUpRequest(upRequest1);
//        elevator.sendUpRequest(upRequest2);
//
//        // One person outside of the elevator at floor 4 pressed button to go down to floor 0
//        elevator.sendDownRequest(downRequest3);
//
//        // Two person inside of the elevator pressed button to go down to floor 1 and 2.
//        elevator.sendDownRequest(downRequest1);
//        elevator.sendDownRequest(downRequest2);
//
//
//        elevator.run();
//    }
//
//}
//
//enum Direction {
//    UP, DOWN, IDLE
//}
//
//enum RequestType {
//    INSIDE_ELEVATOR, OUTSIDE_ELEVATOR
//}
//
//class Request {
//
//    int currentFloor;
//    int desiredFloor;
//    Direction direction;
//    RequestType requestType;
//
//    public Request(int currentFloor, int desiredFloor, Direction direction, RequestType requestType) {
//        this.currentFloor = currentFloor;
//        this.desiredFloor = desiredFloor;
//        this.direction = direction;
//        this.requestType = requestType;
//    }
//}