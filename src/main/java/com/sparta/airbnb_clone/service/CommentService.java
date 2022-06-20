package com.sparta.airbnb_clone.service;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.repository.CommentRepository;
import com.sparta.airbnb_clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
>>>>>>> eb40fb83f6b5ea4ba4848ce1a40745ef6852f699

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
