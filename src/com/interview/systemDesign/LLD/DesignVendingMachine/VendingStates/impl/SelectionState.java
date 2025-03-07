package com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.impl;

import com.interview.systemDesign.LLD.DesignVendingMachine.Item;
import com.interview.systemDesign.LLD.DesignVendingMachine.VendingMachine;
import com.interview.systemDesign.LLD.DesignVendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class SelectionState implements State {

    List<Item> list = new ArrayList<>();

    public SelectionState(){
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception{

        //1. get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);
        list.add(item);

    }

    @Override
    public void processPayment(int amount) throws Exception {

    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
