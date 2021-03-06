package com.sparta.airbnb_clone.service;


import com.sparta.airbnb_clone.dto.TokenDto;
import com.sparta.airbnb_clone.dto.TokenRequestDto;
import com.sparta.airbnb_clone.dto.UsersRequestDto;
import com.sparta.airbnb_clone.dto.UsersResponseDto;
import com.sparta.airbnb_clone.model.RefreshToken;
import com.sparta.airbnb_clone.model.Users;
import com.sparta.airbnb_clone.repository.RefreshTokenRepository;
import com.sparta.airbnb_clone.repository.UserRepository;
import com.sparta.airbnb_clone.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private  final PasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;


    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;


    /*회원가입*/
    @Transactional
    public Users signup(UsersRequestDto requestDto) {
        if (userRepository.existsByUserId(requestDto.getUserId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Users user = requestDto.toUser(passwordEncoder);
        return userRepository.save(user);
    }

    /*로그인*/
    @Transactional
    public TokenDto login(UsersRequestDto requestDto) {
        Users user = userRepository.findByUserId(requestDto.getUserId()).orElse(null);
        String find = user.getNickName();

        Optional<RefreshToken> exist = refreshTokenRepository.findRefreshTokenByKey(find);


        if (exist.isPresent()){
            throw new RuntimeException("이미로그인된 사용자 입니다.");
        } else {
            // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
            UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();


            // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
            //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            // 3. 인증 정보를 기반으로 JWT 토큰 생성
            TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

            tokenDto.setUserId(requestDto.getUserId());


            assert user != null;
            tokenDto.setNickName(user.getNickName());


            // 4. RefreshToken 저장
            RefreshToken refreshToken = RefreshToken.builder()
                    .key(authentication.getName())
                    .value(tokenDto.getRefreshToken())
                    .build();

            refreshTokenRepository.save(refreshToken);

            // 5. 토큰 발급
            return tokenDto;
        }
    }

    /*토큰재발급*/
    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. 저장소에서 Member ID 를 기반으로 Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 6. 저장소 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        // 토큰 발급
        return tokenDto;
    }








}
