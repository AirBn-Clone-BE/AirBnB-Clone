package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.*;
import com.sparta.airbnb_clone.exception.StatusEnum;
import com.sparta.airbnb_clone.model.Users;
import com.sparta.airbnb_clone.repository.UserRepository;
import com.sparta.airbnb_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    private final UserRepository userRepository;



    @PostMapping("/signup")
    public ResponseEntity<MyDto> signup(@RequestBody UsersRequestDto requestDto) {

        MyDto dto = new MyDto();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if (userRepository.existsByUserId(requestDto.getUserId())) {
//            throw new RuntimeException("이미 가입되어 있는 유저입니다");
            dto.setStatus(StatusEnum.BAD_REQUEST);
            dto.setData("");
            dto.setMessage("이미 가입되어 있는 userId가 존재합니다.");
            return new ResponseEntity<>(dto,header, HttpStatus.BAD_REQUEST);
        } else {
            userService.signup(requestDto);
            dto.setStatus(StatusEnum.OK);
            dto.setData(requestDto.getNickName());
            dto.setMessage("회원가입 완료!");
            return new ResponseEntity<>(dto, header, HttpStatus.OK);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok(userService.login(requestDto));
    }
    //30분 유효기간 토큰을 새로 생성?
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(userService.reissue(tokenRequestDto));
    }
}
