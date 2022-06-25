package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.*;
import com.sparta.airbnb_clone.exception.StatusEnum;
import com.sparta.airbnb_clone.model.RefreshToken;
import com.sparta.airbnb_clone.repository.RefreshTokenRepository;
import com.sparta.airbnb_clone.repository.UserRepository;
import com.sparta.airbnb_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;



    @PostMapping("/signup")
    public ResponseEntity<MyDto> signup(@RequestBody UsersRequestDto requestDto) {

        MyDto dto = new MyDto();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        /*Id, nickName 유효성검사*/
        if (userRepository.existsByUserId(requestDto.getUserId())) {
            dto.setStatus(StatusEnum.BAD_REQUEST);
            dto.setData("");
            dto.setMessage("이미 가입되어 있는 userId가 존재합니다.");
            return new ResponseEntity<>(dto,header, HttpStatus.BAD_REQUEST);
        }  else if (userRepository.existsByNickName(requestDto.getNickName())){
            dto.setStatus(StatusEnum.BAD_REQUEST);
            dto.setData("");
            dto.setMessage("이미 가입되어 있는 nickName이 존재합니다.");
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

    @GetMapping("/user/logout")
    public ResponseEntity<MyDto> logout(@RequestBody LogoutDto requestDto) {

        Optional<RefreshToken> find = refreshTokenRepository.findRefreshTokenByValue(requestDto.getRefreshToken());
        Long id = find.get().getId();


        MyDto dto = new MyDto();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        /*refreshToken 대조후 맞으면 삭제*/
        if (refreshTokenRepository.existsByValue(requestDto.getRefreshToken())) {
            dto.setStatus(StatusEnum.OK);
            dto.setData("");
            dto.setMessage("로그아웃 완료!");
            refreshTokenRepository.deleteById(id);
            return new ResponseEntity<>(dto, header, HttpStatus.BAD_REQUEST);
        } else {
            dto.setStatus(StatusEnum.BAD_REQUEST);
            dto.setData("");
            dto.setMessage("유효하지 않는 아이디 입니다 다시 확인 바랍니다.");
            return new ResponseEntity<>(dto, header, HttpStatus.BAD_REQUEST);
        }
    }


    //30분 유효기간 토큰을 새로 생성?
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(userService.reissue(tokenRequestDto));
    }
}
