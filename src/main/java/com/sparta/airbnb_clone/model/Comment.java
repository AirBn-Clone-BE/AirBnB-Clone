package com.sparta.airbnb_clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.airbnb_clone.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long houseId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String comment;


    public Comment(CommentRequestDto requestDto, Long houseId, String nickName){
        this.comment = requestDto.getComment();
        this.houseId = houseId;
        this.nickName = nickName;
    }

}
