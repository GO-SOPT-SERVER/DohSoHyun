package org.sopt.account.interfaces;

public interface AccountAction {
    public void putMoney(int money);
    public void outMoney(int money);
    public void getRemaining();
}
