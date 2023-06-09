package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.ThirdSeminar.controller.dto.request.UserRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.UserResponseDto;
import sopt.org.ThirdSeminar.domain.User;
import sopt.org.ThirdSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto requestDto){
        User user = User.builder()
                .email(requestDto.getEmail())
                .nickname(requestDto.getNickname())
                .password(requestDto.getPassword())
                .build();

        userRepository.save(user);

        return UserResponseDto.of(user.getId(), user.getNickname());
    }
}
