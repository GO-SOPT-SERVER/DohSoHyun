package org.sopt.ThirdSeminarChallenge.post.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.ThirdSeminarChallenge.user.domain.User;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private User user;
    public static PostResponseDto of(Long id, String title, String content, User user) {
        return new PostResponseDto(id, title, content, user);
    }
}
