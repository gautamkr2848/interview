package com.interview.systemDesign.LLD.DesignATM.ATMStates;

import com.interview.systemDesign.LLD.DesignATM.ATM;
import com.interview.systemDesign.LLD.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
