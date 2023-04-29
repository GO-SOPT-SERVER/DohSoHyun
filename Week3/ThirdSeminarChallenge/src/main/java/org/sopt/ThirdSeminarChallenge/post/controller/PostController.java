package org.sopt.ThirdSeminarChallenge.post.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.ThirdSeminarChallenge.global.SuccessStatus;
import org.sopt.ThirdSeminarChallenge.global.dto.ApiResponseDto;
import org.sopt.ThirdSeminarChallenge.post.domain.Post;
import org.sopt.ThirdSeminarChallenge.post.dto.PostRequestDto;
import org.sopt.ThirdSeminarChallenge.post.dto.PostResponseDto;
import org.sopt.ThirdSeminarChallenge.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostResponseDto> create(@RequestBody @Valid final PostRequestDto requestDto){
        return ApiResponseDto.success(SuccessStatus.POST_SUCCESS, postService.create(requestDto));
    }

    @GetMapping("/post/{title}")
    public String find(@PathVariable String title){
        return postService.findByTitle(title).getContents();
    }
}
