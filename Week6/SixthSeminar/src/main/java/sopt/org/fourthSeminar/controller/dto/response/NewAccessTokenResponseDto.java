package sopt.org.fourthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewAccessTokenResponseDto {
    private Long userId;
    private String accessToken;

    public static NewAccessTokenResponseDto of(Long userId, String accessToken){
        return new NewAccessTokenResponseDto(userId, accessToken);
    }
}
