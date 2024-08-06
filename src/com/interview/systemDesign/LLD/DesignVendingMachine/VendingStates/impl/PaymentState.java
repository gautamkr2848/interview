package com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.impl;

import com.interview.systemDesign.LLD.DesignVendingMachine.Item;
import com.interview.systemDesign.LLD.DesignVendingMachine.VendingMachine;
import com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.State;

public class PaymentState implements State {

    public PaymentState(){
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public void processPayment(int amount) throws Exception {

    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed in hasMoney state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }
}
