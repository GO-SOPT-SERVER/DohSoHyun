package org.sopt.account;

import org.sopt.account.interfaces.AccountAction;
import org.sopt.user.User;

public class Account implements AccountAction {
    public User owner;
    public String accountNumber;
    public int remaining;
    //비밀번호는 패키지가 다른 User에서는 접근이 불가능하다.
    private String password;

    //계좌 등록 생성자 this와 this() 키워드 사용
    public Account(User owner, String accountNumber, String password){
        this(owner, accountNumber, 0, password);
    }

    //오버로딩
    public Account(User owner, String accountNumber, int startInput, String password){
        this.remaining = startInput;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.password = password;
    }
    //계좌의 공통적인 행위를 오버라이드(인터페이스에서)
    @Override
    public void putMoney(int money){
        this.remaining += money;
    }
    @Override
    public void outMoney(int money){
        this.remaining -= money;
    }
    @Override
    public void getRemaining(){
        System.out.println("[잔액 확인]");
        System.out.println("잔액은 " + this.remaining + "입니다.");
    }

    public boolean checkPassword(String pw){
        if(this.password.equals(pw)) return true;
        return false;
    }
}
