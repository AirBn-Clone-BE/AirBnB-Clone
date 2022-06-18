package com.sparta.airbnb_clone.dto;

import com.sparta.airbnb_clone.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {

    private String userId;


    public static UsersResponseDto of(Users user) {
        return new UsersResponseDto(user.getUserId());
    }

}
