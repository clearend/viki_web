package com.example.viki.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {
    Goods findByMallCategoryId(Integer mallCategoryId);
}
