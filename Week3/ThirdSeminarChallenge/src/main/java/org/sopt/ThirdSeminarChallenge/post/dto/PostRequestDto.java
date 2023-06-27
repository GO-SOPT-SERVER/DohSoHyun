package org.sopt.ThirdSeminarChallenge.post.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.ThirdSeminarChallenge.user.domain.User;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestDto {
    @NotNull
    private String title;

    @NotNull
    private String contents;

    @NotNull
    private String name;
}
