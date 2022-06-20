package com.sparta.airbnb_clone.service;

import com.sparta.airbnb_clone.dto.HouseRequestDto;
import com.sparta.airbnb_clone.exception.CustomErrorException;
import com.sparta.airbnb_clone.model.House;
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



    //숙소 등록하기
    @Transactional
    public House addHouse(HouseRequestDto requestDto, String username) {


        //동일한 이름의 숙소가 있는지 확인 후, 존재하면 에러 날림
        houseRepository.findByHouseName(requestDto.getHouseName()).ifPresent(
                m -> {
                    throw new CustomErrorException("이미 등록된 이름의 숙소입니다");
                }
        );

        House house = new House(requestDto, username);
        houseRepository.save(house);
        return house;
    }

//    //숙소 상세보기
//    public HouseResponseDto readHouse(Long id) {
//        House house = houseRepository.findById(id).orElseThrow(
//                () -> new CustomErrorException("해당 숙소가 없습니다")
//        );
//        HouseResponseDto houseResponseDto = new HouseResponseDto(
//                house.getId(),
//                house.getHouseName(),
//                house.getPrice(),
//                house.getAddress(),
//                house.getImage(),
//                house.getUser(),
//                house.getPersonCnt()
//        );
//        return houseResponseDto;
//    }

//    //숙소 수정하기
//    @Transactional
//    public void putHouse(HouseRequestDto requestDto) {
//        Long id = requestDto.getId();
//        System.out.println("수정 id = " + id);
//        House house = houseRepository.findById(id).orElseThrow(
//                ()-> new CustomErrorException("해당 숙소가 없습니다")
//        );
//        System.out.println("house 수정 = " + house);
//        house.updateHouse(requestDto);
//    }

//    //숙소 삭제하기
//    public void deleteHouse(Long id) {
//        House house = houseRepository.findById(id).orElseThrow(
//                ()-> new CustomErrorException("해당 숙소가 없습니다")
//        );
//        houseRepository.delete(house);
//    }

}
