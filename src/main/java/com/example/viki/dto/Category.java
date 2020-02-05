package com.example.viki.dto;

import com.example.viki.goods.Goods;
import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer mallCategoryId;
    private String mallCategoryName;
    private String comments;
    private String imageUrl;
    private List<Goods> goodsList;
}
