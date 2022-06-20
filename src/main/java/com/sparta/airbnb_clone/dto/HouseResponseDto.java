package com.sparta.airbnb_clone.dto;


<<<<<<< HEAD
import com.sparta.airbnb_clone.model.Users;
=======
import com.sparta.airbnb_clone.model.User;
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
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


<<<<<<< HEAD
    private Users nickName;

    public HouseResponseDto(Long id, String houseName, int price, String houseInfo, String address, Users nickName, String image, int personCnt) {
=======
    private User user;

    public HouseResponseDto(Long id, String houseName, int price, String houseInfo, String address, String image, int personCnt) {
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
        this.id = id;
        this.houseName = houseName;
        this.price = price;
        this.houseInfo = houseInfo;
        this.address = address;
<<<<<<< HEAD
        this.nickName = nickName;
=======
>>>>>>> a4dadfb5b006dfc54276c82beb82358f53e6fd5a
        this.image = image;
        this.personCnt = personCnt;
    }
}