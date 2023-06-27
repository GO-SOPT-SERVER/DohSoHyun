package org.sopt.ThirdSeminarChallenge.user.repository;

import org.sopt.ThirdSeminarChallenge.user.domain.User;
import org.springframework.data.repository.Repository;


public interface UserRepository extends Repository<User, Long> {
    void save(User user);
    User findUserByName(String name);
}
