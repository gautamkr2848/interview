package com.interview.systemDesign.DesignVendingMachine.VendingStates.impl;

import com.interview.systemDesign.DesignVendingMachine.Item;
import com.interview.systemDesign.DesignVendingMachine.VendingMachine;
import com.interview.systemDesign.DesignVendingMachine.VendingStates.State;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("you can not choose Product in idle state");
    }

    @Override
    public void processPayment(int amount) throws Exception {
        throw new Exception("first you need to click on product selection button");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("proeduct can not be dispensed idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
