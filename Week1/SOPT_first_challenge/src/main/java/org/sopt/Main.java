package org.sopt;

import org.sopt.account.DepositAccount;
import org.sopt.bankTeller.NewUser;
import org.sopt.bankTeller.OpenAccount;
import org.sopt.bankTeller.SendingAction;
import org.sopt.user.User;

public class Main {
    public static void main(String[] args) {
        NewUser newUser = new NewUser("은행원");
        User user1 = newUser.makeUser();
        User user2 = newUser.makeUser();
        OpenAccount openAccount = new OpenAccount("은행원");
        openAccount.work(user1);
        openAccount.work(user2);
        //형변환
        SendingAction sendingAction = new SendingAction((DepositAccount) user1.accountList.get(0), (DepositAccount) user2.accountList.get(0), "은행원");
    }
}