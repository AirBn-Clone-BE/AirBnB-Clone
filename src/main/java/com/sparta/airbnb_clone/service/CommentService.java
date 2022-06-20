package com.sparta.airbnb_clone.service;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long houseId, String username) {

        Comment comment = new Comment(requestDto, houseId,username);
        commentRepository.save(comment);
        return comment;
    }


}
