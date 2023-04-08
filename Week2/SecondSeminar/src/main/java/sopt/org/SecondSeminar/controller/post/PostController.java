package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.PostSaveRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.service.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String save(@RequestBody final PostSaveRequestDto requestDto){
        Long postId = postService.save(requestDto);
        System.out.println(postList.get(postId.intValue()-1).toString());

        return postId + "번 게시물이 등록되었습니다.";
    }

    @GetMapping("/post/{postId}")
    public String getOnePost(@PathVariable final Long postId){
        Post post = postList.get(postId.intValue()-1);
        String name = post.getName();
        String contents = post.getContents();
        return "제목: " + name + "내용: " + contents;
    }

    @GetMapping("/post/search")
    public String search(@RequestParam final String name){
        return postService.searchByName(name);
    }
}
