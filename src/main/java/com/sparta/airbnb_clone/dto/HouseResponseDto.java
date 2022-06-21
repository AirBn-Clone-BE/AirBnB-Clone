package com.sparta.airbnb_clone.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HouseResponseDto {
    private String address;
    private String houseName;
    private String image;
    private int price;
    private String houseInfo;
    private int personCnt;

    private boolean wifi;

    private boolean parking;



    public HouseResponseDto(String houseName, int price, String houseInfo, String address, String image, int personCnt) {

        this.houseName = houseName;
        this.price = price;
        this.houseInfo = houseInfo;
        this.address = address;
        this.image = image;
        this.personCnt = personCnt;
    }
}