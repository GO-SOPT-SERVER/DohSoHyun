package org.sopt.account;

import org.sopt.user.User;

public class DepositAccount extends Account{
    public DepositAccount(User owner, String accountNumber, int startInput, String password){
        super(owner, accountNumber,startInput,password);
    }

}
