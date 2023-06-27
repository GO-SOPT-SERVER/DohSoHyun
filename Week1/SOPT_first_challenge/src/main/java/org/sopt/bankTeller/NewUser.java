package org.sopt.bankTeller;

import org.sopt.bankTeller.interfaces.Working;
import org.sopt.user.User;

import java.util.Scanner;

public class NewUser implements Working {

    public NewUser(String banker){
        sayHello(banker);
    }
    @Override
    public void sayHello(String banker){
        System.out.println("안녕하세요. " + banker + "입니다. 가입을 도와드리겠습니다.");
    }
    public User makeUser(){
        Scanner s = new Scanner(System.in);
        System.out.println("이름을 입력해주세요.");
        String name = s.nextLine();
        System.out.println("성별을 입력해주세요");
        String dateOfBirth = s.nextLine();
        s.nextLine();
        System.out.println("주민번호를 입력해주세요");
        String idNum = s.nextLine();
        User user = new User(name, dateOfBirth, idNum);
        return user;
    }
}
