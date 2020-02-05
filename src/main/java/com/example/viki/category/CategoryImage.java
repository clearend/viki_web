package com.example.viki.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category_image")
@Data
public class CategoryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imageUrl;
    private String mallCategoryName;
    private Long createTime;
    private Long updateTime;
}
