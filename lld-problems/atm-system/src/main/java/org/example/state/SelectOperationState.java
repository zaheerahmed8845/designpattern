package org.example.state;

import org.example.entity.ATM;
import org.example.enums.ATMStatus;

public class SelectOperationState extends ATMState {
    public SelectOperationState(ATM atm) {
        super(atm);
    }

    @Override
    public void selectOperation() {
        String op = atm.getKeypad().getInput(); // "1" withdraw, "2" balance
        switch (op) {
            case "1" -> {
                atm.setStatus(ATMStatus.Withdraw);
                atm.setState(new CashWithdrawalState(atm));
            }
            case "2" -> {
                atm.setStatus(ATMStatus.BalanceInquiry);
                atm.setState(new CheckBalanceState(atm));
            }
            default -> {
                atm.getScreen().showMessage("Invalid choice.");
                return;
            }
        }
    }
}
