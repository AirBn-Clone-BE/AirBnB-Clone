package com.sparta.airbnb_clone.dto;


import com.sparta.airbnb_clone.model.UserRoleEnum;
import com.sparta.airbnb_clone.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
@Getter
@NoArgsConstructor
public class UsersRequestDto {

    private String userId;
    private String nickName;
    private String password;


    public Users toUser(PasswordEncoder passwordEncoder){
        return Users.builder()
                .userId(userId)
                .nickName(nickName)
                .password(passwordEncoder.encode(password))
                .role(UserRoleEnum.USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(userId,password);
    }
}
