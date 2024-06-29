package com.interview.systemDesign.elevator.model;

import com.interview.systemDesign.elevator.button.Button;
import com.interview.systemDesign.elevator.enums.Direction;
import com.interview.systemDesign.elevator.button.ExternalButton;

public class Floor {
    private int id;
    private Display display;
    private Button button;

    public Floor(int id) {
        this.id= id;
        button= new ExternalButton();
    }

    public void pressButton(Direction dir) {
        button.pressButton(id, dir);
    }

    //called everytime selected elevator moves each floor
    private  void setDisplay(int floor, Direction dir) {
        display.setDir(dir);
        display.setFloor(floor);
    }

}

