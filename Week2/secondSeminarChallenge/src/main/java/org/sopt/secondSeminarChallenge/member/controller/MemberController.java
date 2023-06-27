package org.sopt.secondSeminarChallenge.member.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminarChallenge.member.dto.MemberSaveRequestDto;
import org.sopt.secondSeminarChallenge.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import static org.sopt.secondSeminarChallenge.SecondSeminarChallengeApplication.memberList;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public String save(@RequestBody MemberSaveRequestDto requestDto){
        Long memberId = memberService.save(requestDto);
        System.out.println(memberList.get(memberId.intValue()-1).toString());

        return memberId + "번 사용자가 등록되었습니다.";
    }

    @GetMapping("/member")
    public String searchByEmail(@RequestParam String email){
        return memberService.searchByEmail(email);
    }

    @PutMapping("/member/{memberId}")
    public String update(@PathVariable("memberId") Long id, @RequestBody MemberSaveRequestDto requestDto){
        memberService.update(id, requestDto);
        return "수정 되었습니다.";
    }

    @DeleteMapping("/member/delete/{memberId}")
    public void delete(@PathVariable("memberId") Long id){
        memberService.delete(id);
    }
}
