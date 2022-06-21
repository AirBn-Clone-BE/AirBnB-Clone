package com.sparta.airbnb_clone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseRequestDto {

    private String address;

    private String houseName;

    private String image;

    private int price;

    private String houseInfo;

    private int personCnt;

    private boolean wifi;

    private boolean parking;

}
