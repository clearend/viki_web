package com.example.viki.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subcategory_type")
@Data
public class SubCategoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mallCategoryId;
    private String subCategoryName;
    private Integer subMallCategoryId;


}