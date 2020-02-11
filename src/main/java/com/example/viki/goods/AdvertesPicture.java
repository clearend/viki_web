package com.example.viki.goods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "advertes_picture")
@Data
public class AdvertesPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String pictureAddress;
    private Integer toPlace;
}