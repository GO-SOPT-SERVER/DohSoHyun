package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.PostSaveRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<Post> searchByName(String name){
        List<Post> searchedPosts = postList.stream()
                .filter(post -> post.getName().equals(name))
                .collect(Collectors.toList());
        return searchedPosts;
    }
}
