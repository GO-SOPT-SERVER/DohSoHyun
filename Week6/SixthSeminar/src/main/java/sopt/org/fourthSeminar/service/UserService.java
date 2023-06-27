package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sopt.org.fourthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.fourthSeminar.controller.dto.request.UserRequestDto;

import sopt.org.fourthSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSeminar.domain.User;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.BadRequestException;
import sopt.org.fourthSeminar.exception.model.ConflictException;
import sopt.org.fourthSeminar.exception.model.NotFoundException;
import sopt.org.fourthSeminar.exception.model.UnauthorizedException;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtService jwtService;


    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserResponseDto.of(newUser.getId(), newUser.getNickname());
    }
    @Transactional
    public Long login(UserLoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException(Error.INVALID_PASSWORD_EXCEPTION, Error.INVALID_PASSWORD_EXCEPTION.getMessage());
        }

        return user.getId();
    }


    @Transactional
    public NewAccessTokenResponseDto auto_login(AccessTokenRequestDto requestDto) throws UnauthorizedException{
        if(!jwtService.verifyToken(requestDto.getRefreshToken())){
            throw new UnauthorizedException(Error.TOKEN_NOT_VERIFIED_EXCEPTION, Error.TOKEN_NOT_VERIFIED_EXCEPTION.getMessage());
        }
        Long userId = Long.valueOf(jwtService.getJwtContents(requestDto.getRefreshToken()));
        String newAccessKey = jwtService.issuedAccessToken(String.valueOf(userId));
        return NewAccessTokenResponseDto.of(userId, newAccessKey);
    }

}
