package org.sopt.ThirdSeminarChallenge.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.ThirdSeminarChallenge.user.domain.User;
import org.sopt.ThirdSeminarChallenge.user.dto.UserRequestDto;
import org.sopt.ThirdSeminarChallenge.user.dto.UserResponseDto;
import org.sopt.ThirdSeminarChallenge.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto requestDto){
        User user = User.builder()
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .build();
        userRepository.save(user);
        return UserResponseDto.of(user.getId(), user.getName(), user.getEmail());
    }
}
