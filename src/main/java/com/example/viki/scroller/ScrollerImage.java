package com.example.viki.scroller;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "scroller_image")
@Data
public class ScrollerImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imageUrl;
    private Long createTime;
    private Long updateTime;
}
