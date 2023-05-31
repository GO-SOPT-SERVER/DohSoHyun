package sopt.org.fourthSeminar.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RefreshTokenRequestDto {
    Long userId;
    String refreshToken;
}
