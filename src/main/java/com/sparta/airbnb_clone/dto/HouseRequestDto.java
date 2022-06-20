package com.sparta.airbnb_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseRequestDto {
    private Long id;
    private String houseName;
    private int price;
    private String houseInfo;
    private String address;
    private String image;
    private int personCnt;

    public HouseRequestDto(String houseName, int price, String houseInfo, String address, String image, int personCnt) {
        this.houseName = houseName;
        this.price = price;
        this.houseInfo = houseInfo;
        this.address = address;
        this.image = image;
        this.personCnt = personCnt;
    }
}
