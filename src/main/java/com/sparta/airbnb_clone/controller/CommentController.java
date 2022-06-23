package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import com.sparta.airbnb_clone.dto.MyDto;
import com.sparta.airbnb_clone.exception.StatusEnum;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.model.House;
import com.sparta.airbnb_clone.repository.CommentRepository;
import com.sparta.airbnb_clone.repository.HouseRepository;
import com.sparta.airbnb_clone.security.SecurityUtil;
import com.sparta.airbnb_clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    private final HouseRepository houseRepository;


    //숙소 상세 불러오기
    @GetMapping("/api/detail/{id}")
    public List<House> getAllHouse(@PathVariable Long id){
        List<House> house= houseRepository.findAllById(id);
        return house;
    }




    //댓글 등록
    // 프론트에서 토큰 정보 보내줄 때 앞에 Bearer 붙이고(중요x99999) 한 칸 띄어서 accessToken 값 붙여서 보내줘야 details 정보 불러올 수 있음
    @PostMapping("/api/comment/{houseId}")
    public ResponseEntity<MyDto> createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long houseId) {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            User principal = (User) authentication.getPrincipal();
//            String username = principal.getUsername();

        MyDto dto = new MyDto();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        dto.setStatus(StatusEnum.OK);
        dto.setData(houseId);
        dto.setMessage("댓글 등록 완료!");

        String userId = SecurityUtil.getCurrentUserId();
        commentService.createComment(requestDto, houseId, userId);

        return new ResponseEntity<>(dto, header, HttpStatus.OK);


    }

    //댓글 조회
    @GetMapping("/api/allcomment/{houseId}")
    public List<Comment> getAllCommnet(@PathVariable Long houseId){
        List<Comment> comments= commentRepository.findAllByHouseId(houseId);
        return comments;
    }



    //댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<MyDto> deleteComment(@PathVariable Long id){

        MyDto dto = new MyDto();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        String username = SecurityUtil.getCurrentUserId(); //현제 유저 닉네임
        Optional<Comment> a = commentRepository.findById(id);
        String username1 = a.get().getNickName();

        if (Objects.equals(username, username1)) {   //댓글의 닉네임와 일치한다면
            commentRepository.deleteById(id);
            dto.setStatus(StatusEnum.OK);
            dto.setData(id);
            dto.setMessage("댓글 삭제!");
            return new ResponseEntity<>(dto, header, HttpStatus.OK);
        }else{
            dto.setStatus(StatusEnum.BAD_REQUEST);
            dto.setData(id);
            dto.setMessage("사용자의 댓글이 아닙니다!");
            return new ResponseEntity<>(dto,header, HttpStatus.BAD_REQUEST);
        }
        }

    }

