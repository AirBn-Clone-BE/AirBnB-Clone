package com.sparta.detailpage.Controller;

import com.sparta.detailpage.Dto.CommentRequestDto;
import com.sparta.detailpage.Model.Comment;
import com.sparta.detailpage.Repository.CommentRepository;
import com.sparta.detailpage.service.CommentService;
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

