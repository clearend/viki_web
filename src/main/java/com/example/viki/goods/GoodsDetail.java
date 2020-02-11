package com.example.viki.goods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "goods_detail")
@Data
public class GoodsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String goodsId;
    private Integer id;
    private Double oriPrice;
    private Double presentPrice;
    private String imageUrl;
    private String goodsName;
}