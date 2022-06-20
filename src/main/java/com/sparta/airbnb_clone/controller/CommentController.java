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

        //댓글 조회
    @GetMapping("/api/comment/{houseId}")
    public List<Comment> getAllCommnet(@PathVariable Long houseId){
        List<Comment> comments= commentRepository.findAllByHouseId(houseId);
        return comments;
    }


    //@GetMapping("/api/commentButton/{userId}")//삭제 버튼
    //public boolean getButton(@PathVariable Long userId){
     //boolean button= true;
    //int id = 1;// 현제 로그인한 유저의 pk
    //if(id!=userId){// 현제 로그인한 유저의 pk != 댓글을 생성할때 저장시킨 아이디
    //button = false;
    //}else{
    //button =true;
    //}
    //return button;
    //}


    //댓글 삭제(일단 기능만)
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id){

        commentRepository.deleteById(id);
        return id;
    }






    }

