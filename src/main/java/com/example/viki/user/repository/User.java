package com.example.viki.user.repository;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    private String token;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 性别(0:男  1:女)
     */
    private Integer gender;

    /**
     * email
     */
    private String email;

    /**
     * age
     */
    private Integer age;
    /**
     * 联系方式
     */
    private Long phoneNumber;

    /**
     * 创建时间（时间戳13位）
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

}
