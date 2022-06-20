package com.sparta.airbnb_clone.model;

import com.sparta.airbnb_clone.util.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column
    private String provider;


    public Users(String userId, String nickName, String password, UserRoleEnum role) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.role = role;
    }


    @Builder
    public Users(String userId, String password, UserRoleEnum role, String nickName) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.role = role;


    }


}
