package org.sopt.secondSeminarChallenge.member.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberSaveRequestDto {
    private String email;
    private String name;
}
