package com.sparta.airbnb_clone.repository;

import com.sparta.airbnb_clone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {

    Optional<Users> findByUserId(String userId);

    boolean existsByUserId(String userId);

}
