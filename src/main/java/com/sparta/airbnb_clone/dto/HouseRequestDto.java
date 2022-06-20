package com.sparta.airbnb_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
