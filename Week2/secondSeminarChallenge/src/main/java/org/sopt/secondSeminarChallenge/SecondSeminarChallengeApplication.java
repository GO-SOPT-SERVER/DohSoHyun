package org.sopt.secondSeminarChallenge;

import org.sopt.secondSeminarChallenge.member.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SecondSeminarChallengeApplication {

	public static ArrayList<Member> memberList;
	public static void main(String[] args) {
		SpringApplication.run(SecondSeminarChallengeApplication.class, args);
		memberList = new ArrayList<>();
	}

}
