package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.TokenDto;
import com.sparta.airbnb_clone.dto.TokenRequestDto;
import com.sparta.airbnb_clone.dto.UsersRequestDto;
import com.sparta.airbnb_clone.dto.UsersResponseDto;
import com.sparta.airbnb_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    @PostMapping("/signup")
//    public UsersResponseDto signupP(@RequestBody UsersRequestDto requestDto) {return userService.signupP(requestDto);}



    @PostMapping("/signup")
    public ResponseEntity<UsersResponseDto> signup(@RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok(userService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UsersRequestDto requestDto) {
        return ResponseEntity.ok(userService.login(requestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(userService.reissue(tokenRequestDto));
    }
}
