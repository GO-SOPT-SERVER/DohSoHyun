package sopt.org.SecondSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.PostSaveRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;

import java.io.IOException;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {

    public Long save(PostSaveRequestDto requestDto){
        Post newPost = new Post(
                requestDto.getName(),
                requestDto.getContents()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        return newPost.getId();
    }

    public String searchByName(String name){
        Post post = new Post("","");
        for(int i = 0; i < postList.size(); i++){
            Post postIn = postList.get(i);

            if(postIn.getName().equals(name)){
                post = postIn;
                String content = post.getContents();
                String postName = post.getName();
                return "제목: " + postName + " 내용: "+ content;
            }
        }
        return "해당 게시물이 없습니다.";
    }
}
