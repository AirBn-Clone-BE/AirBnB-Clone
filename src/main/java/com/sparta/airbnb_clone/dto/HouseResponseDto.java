package com.sparta.airbnb_clone.dto;


import com.sparta.airbnb_clone.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseResponseDto {
    private Long id;
    private String houseName;
    private int price;
    private String houseInfo;
    private String address;
    private String image;

    private int personCnt;


    private Users nickName;

    public HouseResponseDto(Long id, String houseName, int price, String houseInfo, String address, Users nickName, String image, int personCnt) {
        this.id = id;
        this.houseName = houseName;
        this.price = price;
        this.houseInfo = houseInfo;
        this.address = address;
        this.nickName = nickName;
        this.image = image;
        this.personCnt = personCnt;
    }
}