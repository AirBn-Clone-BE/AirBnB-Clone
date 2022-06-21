package com.sparta.airbnb_clone.repository;


import com.sparta.airbnb_clone.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findAllByAddress(String address);

    Optional<House> findById(Long id);

    List<House> findAllById (Long id);

    Optional<House> findByHouseName(String houseName);


}