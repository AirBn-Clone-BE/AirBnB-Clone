package com.sparta.airbnb_clone.controller;

import com.sparta.airbnb_clone.dto.HouseRequestDto;
import com.sparta.airbnb_clone.model.House;
import com.sparta.airbnb_clone.service.HouseService;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {

    private final HouseService houseService;

    HouseController(HouseService houseService) {
        this.houseService = houseService;
    }


    //숙소 등록하기
    @PostMapping("/api/house")
    public House addHouse(@RequestBody HouseRequestDto houseRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
////        if(userDetails == null) {
//            throw new CustomErrorException("로그인이 필요합니다.");
//        }
        //숙소 등록하기 로직
        House house = houseService.addHouse(houseRequestDto, username);
        return house;
    }

//    //상세보기
//    @PostMapping("/api/details")
//    public ResponseDto readHouse(@RequestBody HashMap<String, Long> map){
//        Long id = map.get("id");
//        HouseResponseDto houseResponseDto = houseService.readHouse(id);
//        return new ResponseDto("success", "상세보기에 성공했습니다.", houseResponseDto);
//    }


//    //숙소 수정하기
//
//            @PutMapping("/api/house/{houseId}")
//            public ResponseDto putHouse (@RequestBody HouseRequestDto
//            requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String houseId){
//                if (userDetails == null) {
//
//                    throw new CustomErrorException("로그인이 필요합니다.");
//                }
//
//                houseService.putHouse(requestDto);
//                return new ResponseDto("success", "숙소 정보가 수정되었습니다.", "");
//            }

//            //숙소 삭제하기
//                    @DeleteMapping("/api/house/{houseId}")
//                    public ResponseDto deleteHouse
//                    (@RequestBody HashMap < String, Long > map, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String houseId){
//                        Long id = map.get("id");
//
//                        if (userDetails == null) {
//
//                            throw new CustomErrorException("로그인이 필요합니다.");
//                        }
//
//                        houseService.deleteHouse(id);
//                        return new ResponseDto("success", "숙소가 삭제되었습니다.", "");
//                    }
//                }
//            }
}

