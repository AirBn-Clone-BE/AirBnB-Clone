package com.sparta.airbnb_clone.security;

import com.sparta.airbnb_clone.model.Users;
import com.sparta.airbnb_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;




    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = userRepository.findByUserId(userId).orElseThrow(
                () -> new UsernameNotFoundException(userId + "이 존재하지 않습니다")
        );
        return new UserDetailsImpl(user);

    }

}