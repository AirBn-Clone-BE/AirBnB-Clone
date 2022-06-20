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


<<<<<<< HEAD
//    private final UserRepository memberRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = userRepository.findByUserId(userId).orElseThrow(
=======
<<<<<<< HEAD


    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = userRepository.findByUserId(userId).orElseThrow(
=======
    private final UserRepository memberRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = memberRepository.findByUserId(userId).orElseThrow(
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
>>>>>>> eb40fb83f6b5ea4ba4848ce1a40745ef6852f699
                () -> new UsernameNotFoundException(userId + "이 존재하지 않습니다")
        );
        return new UserDetailsImpl(user);

    }

}