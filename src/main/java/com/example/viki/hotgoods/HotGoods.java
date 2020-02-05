package com.example.viki.hotgoods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hot_goods")
@Data
public class HotGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double mallPrice;
    private String imageUrl;
    private String goodsId;
    private Double price;
    private String name;
}