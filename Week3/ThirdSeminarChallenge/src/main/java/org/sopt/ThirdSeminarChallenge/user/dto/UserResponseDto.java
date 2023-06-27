package org.sopt.ThirdSeminarChallenge.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    public static UserResponseDto of(Long id, String name, String email){
        return new UserResponseDto(id, name, email);
    }
}
