package com.interview.systemDesign.LLD.DesignVendingMachine;

import com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.State;
import com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.impl.IdleState;

public class VendingMachine {

    private State vendingMachineState;
    private Inventory inventory;

    public VendingMachine(){
        vendingMachineState = new IdleState();
        inventory = new Inventory(10);
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
