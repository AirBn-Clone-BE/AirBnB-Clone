package com.sparta.airbnb_clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Users {

    @GeneratedValue(strategy = GenerationType.AUTO) // 자동으로 1씩 증가
    @Id
    private Long id;
}
