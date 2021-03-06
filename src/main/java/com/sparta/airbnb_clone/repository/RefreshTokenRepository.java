package com.sparta.airbnb_clone.repository;

import com.sparta.airbnb_clone.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByKey(String key);

    Optional<RefreshToken> findRefreshTokenByKey(String key);
    Optional<RefreshToken> findRefreshTokenByValue(String value);


    boolean existsByValue(String value);


}