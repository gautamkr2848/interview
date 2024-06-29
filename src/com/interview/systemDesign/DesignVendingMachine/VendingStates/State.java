package com.interview.systemDesign.DesignVendingMachine.VendingStates;

import com.interview.systemDesign.DesignVendingMachine.Item;
import com.interview.systemDesign.DesignVendingMachine.VendingMachine;

import java.util.List;

public interface State {

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public void processPayment(int amount) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;

}
