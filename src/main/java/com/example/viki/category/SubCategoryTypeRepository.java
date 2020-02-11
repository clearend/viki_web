package com.example.viki.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryTypeRepository extends JpaRepository<SubCategoryType,Integer> {

    SubCategoryType findBySubMallCategoryIdAndMallCategoryId(Integer categorySubId,Integer categoryId);
}
