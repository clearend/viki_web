package com.example.viki.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDetailRepository extends JpaRepository<GoodsDetail,Integer> {
    GoodsDetail findByGoodsId(String mallSubId);
}
