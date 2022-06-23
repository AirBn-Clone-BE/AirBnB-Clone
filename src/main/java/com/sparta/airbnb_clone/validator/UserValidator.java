package com.sparta.airbnb_clone.validator;

import com.sparta.airbnb_clone.dto.MyDto;
import com.sparta.airbnb_clone.dto.UsersRequestDto;
import com.sparta.airbnb_clone.exception.StatusEnum;
import com.sparta.airbnb_clone.repository.UserRepository;
import com.sparta.airbnb_clone.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class UserValidator {

    private static UserRepository userRepository;
    private static UserService userService;

    private static void validateSignup(UsersRequestDto requestDto, MyDto dto) {
        if (!userRepository.existsByNickName(requestDto.getNickName())){
            userService.signup(requestDto);
            dto.setStatus(StatusEnum.OK);
            dto.setData(requestDto.getNickName());
            dto.setMessage("회원가입 완료!");
        }
    }

}
