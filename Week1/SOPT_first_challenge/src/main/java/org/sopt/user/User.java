package org.sopt.user;

import org.sopt.account.Account;

import java.util.ArrayList;
import java.util.List;
public class User {
    public String name;
    public String gender;

    public List<Account> accountList = new ArrayList<>();
    private String identifyNum;

    public User(String name, String gender, String identifyNum){
        this.name = name;
        this.gender = gender;
        this.identifyNum = identifyNum;
    }
    public void addAccount(Account account){
        accountList.add(account);
    }
}
