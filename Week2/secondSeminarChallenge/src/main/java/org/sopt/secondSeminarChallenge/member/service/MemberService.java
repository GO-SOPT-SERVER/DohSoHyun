package org.sopt.secondSeminarChallenge.member.service;

import org.sopt.secondSeminarChallenge.member.domain.Member;
import org.sopt.secondSeminarChallenge.member.dto.MemberSaveRequestDto;
import org.springframework.stereotype.Service;

import static org.sopt.secondSeminarChallenge.SecondSeminarChallengeApplication.memberList;

@Service
public class MemberService {
    public Long save(MemberSaveRequestDto requestDto){
        Member newMember = new Member(
                requestDto.getEmail(),
                requestDto.getName()
        );

        memberList.add(newMember);
        newMember.setId((long)memberList.size());

        return newMember.getId();
    }

    public String searchByEmail(String email){
        for(Member memberIter : memberList){
            if(memberIter.getEmail().equals(email)){
                return "email: " + memberIter.getEmail() +"님의 이름은 " +memberIter.getName() + "입니다.";
            }
        }
        return "해당 사용자는 없습니다.";
    }

    public void update(Long id, MemberSaveRequestDto requestDto){
        String email = requestDto.getEmail();
        String name = requestDto.getName();
        Member member = memberList.get(id.intValue() - 1);
        member.setName(name);
        member.setEmail(email);
    }

    public void delete(Long id){
        Member member = memberList.remove(id.intValue() - 1);
        System.out.println("email: " + member.getEmail() + "유저가 삭제되었습니다.");
    }
}
