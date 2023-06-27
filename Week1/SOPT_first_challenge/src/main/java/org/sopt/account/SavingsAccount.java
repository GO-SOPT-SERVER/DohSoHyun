package org.sopt.account;

import org.sopt.user.User;

public class SavingsAccount extends Account{
    public int dueDate;//만기일
    public int regularInput;//정기 입금 금액
    public double profit; //이율
    public int finishedAmount; //최종 금액

    public SavingsAccount(User owner, String accountNumber, int startInput, String password,
                          int dueDate, int regularInput, double profit){
        //super 키워드 사용
        super(owner, accountNumber, startInput, password);
        this.dueDate = dueDate;
        this.regularInput = regularInput;
        this.profit = profit;
        this.finishedAmount= (dueDate*regularInput)*(int)(Math.pow((1+profit),dueDate));
    }
}
