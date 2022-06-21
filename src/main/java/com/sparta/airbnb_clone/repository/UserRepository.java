package com.sparta.airbnb_clone.repository;

import com.sparta.airbnb_clone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {

    Optional<Users> findByUserId(String userId);

    Optional<Users> findByNickName(String nickName);

    boolean existsByUserId(String userId);

}
