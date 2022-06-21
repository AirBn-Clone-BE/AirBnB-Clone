package com.sparta.airbnb_clone.security;


import com.sparta.airbnb_clone.model.UserRoleEnum;
import com.sparta.airbnb_clone.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Transactional
public class UserDetailsImpl implements UserDetails {

    private final Users user;

    //일반로그인
    public UserDetailsImpl(Users user) {
        this.user = user;
    }

    //OAuth 로그인

    public Users getUser() {
        return user;
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override //숙소 등록 및 댓글작성 시 SecurityUtil.getCurrentUserId();으로 nickName 값 꺼내오기 위해 변경
    public String getUsername() {return user.getNickName();}

    public String getNickName() { return user.getNickName();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

}
