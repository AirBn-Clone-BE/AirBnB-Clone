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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
<<<<<<< HEAD
    private String nickName;

    @Column
=======
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
    private String image;

    @Column(nullable = false)
    private int personCnt;

    //호스트 (숙소 등록한 사람)
<<<<<<< HEAD
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
=======
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


    //숙소 저장용 생성자
    public House(String houseName, String houseInfo, int price, String address, String image, User user, int personCnt) {
        this.houseName = houseName;
        this.houseInfo = houseInfo;
        this.price = price;
        this.address = address;
        this.image = image;
        this.user = user;
        this.personCnt = personCnt;
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
    }

    public void updateHouse(HouseRequestDto requestDto){
        this.houseName = requestDto.getHouseName();
        this.houseInfo = requestDto.getHouseInfo();
        this.price = requestDto.getPrice();
        this.address = requestDto.getAddress();
        this.image = requestDto.getImage();
        this.personCnt = requestDto.getPersonCnt();
    }
}
