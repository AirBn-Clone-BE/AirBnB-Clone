package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.HouseRequestDto;
import com.sparta.airbnb_clone.dto.MyDto;
import com.sparta.airbnb_clone.dto.ResponseDto;
import com.sparta.airbnb_clone.exception.CustomErrorException;
import com.sparta.airbnb_clone.exception.StatusEnum;
import com.sparta.airbnb_clone.model.Comment;
import com.sparta.airbnb_clone.model.House;
import com.sparta.airbnb_clone.repository.HouseRepository;
import com.sparta.airbnb_clone.security.SecurityUtil;
import com.sparta.airbnb_clone.security.UserDetailsImpl;
import com.sparta.airbnb_clone.service.HouseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class HouseController {

    private final HouseService houseService;
    private final HouseRepository houseRepository;

    HouseController(HouseService houseService, HouseRepository houseRepository) {
        this.houseService = houseService;
        this.houseRepository = houseRepository;
    }


    //숙소 등록하기
    @PostMapping("/api/house")
    public House addHouse(@RequestBody HouseRequestDto houseRequestDto) {
        String nickName = SecurityUtil.getCurrentUserId();

        //숙소 등록하기 로직
        House house = houseService.addHouse(houseRequestDto, nickName);
        return house;
    }



    //숙소 상세 모두 불러오기
    @GetMapping("/api/allhouse")
    public List<House> getAllHouse(){
        List<House> houses= houseRepository.findAll();
        return houses;
    }


    //숙소 수정하기

    @PutMapping("/api/house/{id}")
    public Long putHouse(@RequestBody HouseRequestDto requestDto, @PathVariable Long id) {
        houseService.putHouse(requestDto, id);
        return id;
    }


    //숙소 삭제하기
    @DeleteMapping("/api/house/{id}")
    public Long deleteHouse(@PathVariable Long id) {

        houseRepository.deleteById(id);
        return id;

    }

}

