package org.sopt.ThirdSeminarChallenge.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ThirdSeminarChallenge.global.SuccessStatus;
import org.sopt.ThirdSeminarChallenge.global.dto.ApiResponseDto;
import org.sopt.ThirdSeminarChallenge.user.dto.UserRequestDto;
import org.sopt.ThirdSeminarChallenge.user.dto.UserResponseDto;
import org.sopt.ThirdSeminarChallenge.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto requestDto){

        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(requestDto));
    }
}
