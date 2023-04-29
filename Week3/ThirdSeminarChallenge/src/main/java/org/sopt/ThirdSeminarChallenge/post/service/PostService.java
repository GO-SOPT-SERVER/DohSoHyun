package org.sopt.ThirdSeminarChallenge.post.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ThirdSeminarChallenge.post.domain.Post;
import org.sopt.ThirdSeminarChallenge.post.dto.PostRequestDto;
import org.sopt.ThirdSeminarChallenge.post.dto.PostResponseDto;
import org.sopt.ThirdSeminarChallenge.post.repository.PostRepository;
import org.sopt.ThirdSeminarChallenge.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto create(PostRequestDto requestDto) {
        Post post = Post.builder()
                .user(userRepository.findUserByName(requestDto.getName()))
                .contents(requestDto.getContents())
                .title(requestDto.getTitle())
                .build();

        postRepository.save(post);

        return PostResponseDto.of(post.getId(), post.getTitle(),post.getContents(), post.getUser());
    }

    @Transactional
    public Post findByTitle(String title){
        return postRepository.findByTitle(title);
    }
}
