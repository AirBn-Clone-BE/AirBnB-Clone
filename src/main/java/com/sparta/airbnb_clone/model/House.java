package com.sparta.airbnb_clone.model;


import com.sparta.airbnb_clone.dto.HouseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class House {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String houseName;

    @Column(nullable = false)
    private String houseInfo;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String nickName;

    @Column
    private String image;

    @Column(nullable = false)
    private int personCnt;

    //호스트 (숙소 등록한 사람)
   // @ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "USER_ID", nullable = false)
  //  private Users nickName;


    //숙소 저장용 생성자
    public House(HouseRequestDto requestDto, String nickName) {
        this.houseName = requestDto.getHouseName();
        this.houseInfo = requestDto.getHouseInfo();
        this.price = requestDto.getPrice();
        this.address = requestDto.getAddress();
        this.image = requestDto.getImage();
        this.nickName = nickName;
        this.personCnt = requestDto.getPersonCnt();
    }


//    public void updateHouse(HouseRequestDto requestDto){
//        this.houseName = requestDto.getHouseName();
//        this.houseInfo = requestDto.getHouseInfo();
//        this.price = requestDto.getPrice();
//        this.address = requestDto.getAddress();
//        this.image = requestDto.getImage();
//        this.personCnt = requestDto.getPersonCnt();
//    }
}
