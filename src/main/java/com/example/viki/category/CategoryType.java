package com.example.viki.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category_type")
@Data
public class CategoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mallCategoryId;
    private String mallCategoryName;

}