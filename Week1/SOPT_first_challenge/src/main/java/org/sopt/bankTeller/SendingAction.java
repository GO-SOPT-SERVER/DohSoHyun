package org.sopt.bankTeller;

import org.sopt.account.DepositAccount;
import org.sopt.bankTeller.interfaces.Working;

import java.util.Scanner;

public class SendingAction implements Working {
    @Override
    public void sayHello(String banker){
        System.out.println("안녕하세요. " + banker + "입니다. 송금을 도와드리겠습니다.");
    }

    public SendingAction(DepositAccount sender, DepositAccount receiver, String banker){
        sayHello(banker);
        Scanner s= new Scanner(System.in);
        System.out.println("보내시는 금액을 입력해주세요.");
        int amount = s.nextInt();
        s.nextLine();
        System.out.println("계좌 비밀번호 입력해주세요.");
        String pw = s.nextLine();

        //private인 pw에 접근한는 방법!
        if(sender.checkPassword(pw)) {
            sender.remaining -= amount;
            receiver.remaining += amount;
            System.out.println("송금이 완료되었습니다.");
            System.out.println("보내는 계좌의 잔액은" + sender.remaining +"입니다.");
        }else{
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }
}
