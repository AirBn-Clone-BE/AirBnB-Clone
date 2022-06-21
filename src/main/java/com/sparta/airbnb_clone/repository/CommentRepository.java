package com.sparta.airbnb_clone.repository;

import com.sparta.airbnb_clone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByHouseId(Long houseId);

}
