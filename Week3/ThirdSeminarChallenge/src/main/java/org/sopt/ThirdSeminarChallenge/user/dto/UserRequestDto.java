package org.sopt.ThirdSeminarChallenge.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequestDto {
    @NotNull
    private String email;

    @NotBlank
    private String name;
}
