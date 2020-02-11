package com.example.viki.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsInfoRepository extends JpaRepository<GoodsInfo,Integer> {
    GoodsInfo findByGoodsId(String goodsId);
}
