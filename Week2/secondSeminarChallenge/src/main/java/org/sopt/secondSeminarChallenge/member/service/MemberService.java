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


}
