package com.interview.systemDesign.elevator.button;

import com.interview.systemDesign.elevator.enums.Direction;
import com.interview.systemDesign.elevator.ExternalDispatcher;

public class ExternalButton extends Button {

    private ExternalDispatcher edispatcher= ExternalDispatcher.INSTANCE;
    private Direction direction;

    public ExternalDispatcher getEdispatcher() {
        return edispatcher;
    }

    public void setEdispatcher(ExternalDispatcher edispatcher) {
        this.edispatcher = edispatcher;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void pressButton(int floor, Direction dir) {
        direction= dir;
        System.out.println("Pressed " + direction + " from floor " + floor);
        edispatcher.submitRequest(floor, dir);
    }

}

