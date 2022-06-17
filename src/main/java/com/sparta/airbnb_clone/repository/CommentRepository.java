package com.sparta.airbnb_clone.Repository;

import com.sparta.detailpage.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByHouseId(Long houseId);
}
