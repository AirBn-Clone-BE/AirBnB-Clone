package com.sparta.airbnb_clone.service;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a

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
