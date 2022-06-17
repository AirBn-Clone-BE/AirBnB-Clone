package com.sparta.detailpage.service;

import com.sparta.detailpage.Dto.CommentRequestDto;
import com.sparta.detailpage.Model.Comment;
import com.sparta.detailpage.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long houseId){
        String nickName = "도훈";
        Comment comment = new Comment(requestDto, houseId, nickName);
        commentRepository.save(comment);
        return comment;
    }
}
