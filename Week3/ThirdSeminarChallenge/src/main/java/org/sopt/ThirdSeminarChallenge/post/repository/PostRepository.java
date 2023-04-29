package org.sopt.ThirdSeminarChallenge.post.repository;

import org.sopt.ThirdSeminarChallenge.post.domain.Post;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
    void save(Post post);
    Post findByTitle(String title);
}
