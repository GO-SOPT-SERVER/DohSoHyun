package org.sopt.bankTeller;

import org.sopt.account.DepositAccount;
import org.sopt.account.SavingsAccount;
import org.sopt.bankTeller.interfaces.Working;
import org.sopt.user.User;

import java.util.Scanner;

public class OpenAccount implements Working {

    public OpenAccount(String banker) {
        sayHello(banker);
    }

    @Override
    public void sayHello(String banker) {
        System.out.println("안녕하세요. " + banker + "입니다. 계좌 개설을 도와드리겠습니다.");
    }

    public void work(User visitor) {
        Scanner s = new Scanner(System.in);
        System.out.println(visitor.name + "님, 계좌 개설을 도와드리겠습니다.");
        System.out.println("개설하고 싶은 계좌가 무엇인가요? 적금이라면 0, 예금이라면 1을 눌러주세요.");
        int input = s.nextInt();
        if (input == 0) {
            System.out.println("적금을 선택하셨습니다.");
            String accountNumber = (int) (Math.random() * 10000) + "";
            System.out.println("현재 개설과 함께 입금하실 금액을 입력해주세요.");
            int startInput = s.nextInt();
            System.out.println("사용하실 비밀번호를 입력해주세요.");
            String pw = s.nextLine();
            System.out.println("정기적으로 입금할 금액을 입력해주세요.");
            int regularInput = s.nextInt();
            openSavings(visitor, accountNumber, startInput, pw, 24, regularInput, 3.1);
        } else if (input == 1) {
            System.out.println("예금을 선택하셨습니다.");
            String accountNumber = (int) (Math.random() * 10000) + "";
            System.out.println("현재 개설과 함께 입금하실 금액을 입력해주세요.");
            int startInput = s.nextInt();
            s.nextLine();
            System.out.println("사용하실 비밀번호를 입력해주세요.");
            String pw = s.nextLine();
            openDeposit(visitor, accountNumber, startInput, pw);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public void openDeposit(User owner, String accountNumber, int startInput, String password) {
        DepositAccount depositAccount = new DepositAccount(owner, accountNumber, startInput, password);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("예금 계좌 개설이 완료되었습니다. ");
        System.out.println("계좌번호 :" + accountNumber);
        System.out.println("--------------------------------------------------------------------");
        owner.addAccount(depositAccount);
    }

    public void openSavings(User owner, String accountNumber, int startInput, String password,
                            int dueDate, int regularInput, double profit) {
        SavingsAccount savingsAccount = new SavingsAccount(owner, accountNumber, startInput, password, dueDate, regularInput, profit);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("적금 계좌 개설이 완료되었습니다.");
        System.out.println("계좌번호 :" + accountNumber);
        System.out.println("만기 기간은 " + savingsAccount.dueDate + "이고, 매달" + savingsAccount.regularInput + "이 입금 되면 " + savingsAccount.profit + "%의 이율에 따라 " + savingsAccount.finishedAmount + "의 만기금액을 받으실 수 있습니다.");
        System.out.println("--------------------------------------------------------------------");
        owner.addAccount(savingsAccount);
    }
}
