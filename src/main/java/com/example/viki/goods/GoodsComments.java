package com.example.viki.goods;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "good_comments")
@Data
public class GoodsComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String goodsId;
    private Integer score;
    private String comments;
    private String userName;
    private Long discussTime;

}
