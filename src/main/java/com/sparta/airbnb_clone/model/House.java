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

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String houseName;

    @Column(nullable = false)
    private String houseInfo;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String address;

    @Column(length = 8000)
    private String image;

    @Column(nullable = false)
    private int personCnt;

    @Column(nullable = false)
    private boolean wifi;

    @Column(nullable = false)
    private boolean parking;



    //숙소 저장용 생성자
    public House(HouseRequestDto requestDto, String nickName) {
        this.houseName = requestDto.getHouseName();
        this.houseInfo = requestDto.getHouseInfo();
        this.price = requestDto.getPrice();
        this.address = requestDto.getAddress();
        this.image = requestDto.getImage();
        this.nickName = nickName;
        this.personCnt = requestDto.getPersonCnt();
        this.wifi  = requestDto.isWifi();
        this.parking = requestDto.isParking();
    }


    public void updateHouse(HouseRequestDto requestDto){
        this.houseName = requestDto.getHouseName();
        this.houseInfo = requestDto.getHouseInfo();
        this.price = requestDto.getPrice();
        this.address = requestDto.getAddress();
        this.image = requestDto.getImage();
        this.personCnt = requestDto.getPersonCnt();
        this.wifi  = requestDto.isWifi();
        this.parking = requestDto.isParking();
    }
}
