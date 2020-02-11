package com.example.viki.dto;

import com.example.viki.goods.AdvertesPicture;
import com.example.viki.goods.GoodsComments;
import lombok.Data;

import java.util.List;

@Data
public class GoodsInfo {
    private com.example.viki.goods.GoodsInfo goodsInfo;
    private List<GoodsComments> goodsComments;
    private AdvertesPicture advertesPicture;
}
