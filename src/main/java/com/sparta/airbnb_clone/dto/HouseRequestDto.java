package com.sparta.airbnb_clone.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
public class HouseRequestDto {
    private Long id;
    private String houseName;
    private int price;
    private String houseInfo;
    private String address;
    private String image;
    private int personCnt;
<<<<<<< HEAD

    public HouseRequestDto(String houseName, int price, String houseInfo, String address, String image, int personCnt) {
        this.houseName = houseName;
        this.price = price;
        this.houseInfo = houseInfo;
        this.address = address;
        this.image = image;
        this.personCnt = personCnt;
    }
=======
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
}
