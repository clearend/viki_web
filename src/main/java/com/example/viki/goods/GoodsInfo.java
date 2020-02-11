package com.example.viki.goods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "good_info")
@Data
public class GoodsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String goodsId;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private Integer amount;
    private String isOnline;
    private Long goodsSerialNumber;
    private Double oriPrice;
    private Double presentPrice;
    private String comPic;
    private Integer state;
    private String shopId;
    private String goodsName;
    private String goodsDetail;

}
