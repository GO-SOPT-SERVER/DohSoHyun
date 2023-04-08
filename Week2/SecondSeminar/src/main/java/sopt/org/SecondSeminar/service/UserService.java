package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.user.User;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@Service
public class UserService {
    public Long register(RegisterRequestDto requestDto){
        User newUser = new User(
                requestDto.getGender(),
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getAge()
        );

        userList.add(newUser);
        newUser.setId((long) userList.size());

        return newUser.getId();
    }
}
