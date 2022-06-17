package com.sparta.airbnb_clone.model;

import com.sparta.airbnb_clone.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long houseId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto requestDto, Long houseId, String nickname){
        this.comment = requestDto.getComment();
        this.houseId = houseId;
        this.nickName = nickname;
    }


}
