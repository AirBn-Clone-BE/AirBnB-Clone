package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.repository.CommentRepository;
import com.sparta.airbnb_clone.security.SecurityUtil;
import com.sparta.airbnb_clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;


    //댓글 등록
    // 프론트에서 토큰 정보 보내줄 때 앞에 Bearer 붙이고(중요x99999) 한 칸 띄어서 accessToken 값 붙여서 보내줘야 details 정보 불러올 수 있음
    @PostMapping("/api/comment/{houseId}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long houseId){
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            User principal = (User) authentication.getPrincipal();
//            String username = principal.getUsername();
            String userId = SecurityUtil.getCurrentUserId();

            Comment comment = commentService.createComment(requestDto, houseId, userId);
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


    //댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        String username = SecurityUtil.getCurrentUserId(); //현제 유저 아이디
        Optional<Comment> a = commentRepository.findById(id);
        String username1 = a.get().getNickName();
        if (!Objects.equals(username, username1)){
            throw new NullPointerException("본인이 작성한 글만 삭제 가능합니다.");
        }
        commentRepository.deleteById(id);
        return id;
    }






    }

