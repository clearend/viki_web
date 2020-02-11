package com.example.viki.circle;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "circle")
@Data
public class Circle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String userId;
    private Integer userType;
    private String content;
    private String image1;
    private String image2;
    private String image3;
    private String phoneNumber;
}
