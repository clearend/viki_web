package com.example.viki.goods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String mallSubId;
    private Integer mallCategoryId;
    private String mallSubName;
    private String comments;
    private Integer cid;
    private Integer pid;
    private String imageUrl;
}