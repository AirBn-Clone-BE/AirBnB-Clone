package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.repository.CommentRepository;
import com.sparta.airbnb_clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;


    //댓글 등록
    @PostMapping("/api/comment/{houseId}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long houseId){

            Comment comment = commentService.createComment(requestDto, houseId);
            return comment;
        }

        //
    @GetMapping("/api/comment/{houseId}")
    public List<Comment> getAllCommnet(@PathVariable Long houseId){
        return commentRepository.findAllByHouseId(houseId);

    }



    }

