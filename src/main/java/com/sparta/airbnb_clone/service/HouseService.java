package com.sparta.airbnb_clone.service;

import com.sparta.airbnb_clone.dto.HouseRequestDto;
import com.sparta.airbnb_clone.dto.HouseResponseDto;
import com.sparta.airbnb_clone.exception.CustomErrorException;
import com.sparta.airbnb_clone.model.House;
import com.sparta.airbnb_clone.model.User;
import com.sparta.airbnb_clone.repository.HouseRepository;
import com.sparta.airbnb_clone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;
    private final UserRepository userRepository;


    public HouseService(HouseRepository houseRepository, UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }


    //숙소 상세보기
    public HouseResponseDto readHouse(Long id) {
        House house = houseRepository.findById(id).orElseThrow(
                () -> new CustomErrorException("해당 숙소가 없습니다")
        );
        HouseResponseDto houseResponseDto = new HouseResponseDto(
                house.getId(),
                house.getHouseName(),
                house.getPrice(),
                house.getAddress(),
                house.getImage(),
                house.getUser(),
                house.getPersonCnt()
        );
        return houseResponseDto;
    }

    //숙소 등록하기
    @Transactional
    public House addHouse(HouseRequestDto requestDto, UserDetailsImpl userDetails) {
        Long id = userDetails.getUser().getId();

        User user = userRepository.findById(id).orElseThrow(
                () -> new CustomErrorException("존재하지 않는 사용자 입니다.")
        );


        House house = new house(requestDto.getHouseName(), requestDto.getHouseInfo(), requestDto.getPrice(),
                requestDto.getAddress(), requestDto.getImage(), user);

        //db에 숙소 저장
        houseRepository.save(house);


        return house;
    }


    //숙소 수정하기
    @Transactional
    public void putHouse(HouseRequestDto requestDto) {
        Long id = requestDto.getId();
        System.out.println("수정 id = " + id);
        House house = houseRepository.findById(id).orElseThrow(
                ()-> new CustomErrorException("해당 숙소가 없습니다")
        );
        System.out.println("house 수정 = " + house);
        house.updateHouse(requestDto);
    }

    //숙소 삭제하기
    public void deleteHouse(Long id) {
        House house = houseRepository.findById(id).orElseThrow(
                ()-> new CustomErrorException("해당 숙소가 없습니다")
        );
        houseRepository.delete(house);
    }

}
