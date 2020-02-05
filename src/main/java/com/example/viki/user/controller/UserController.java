package com.example.viki.user.controller;


import com.example.viki.common.ApiResponse;
import com.example.viki.dto.Category;
import com.example.viki.goods.Goods;
import com.example.viki.user.repository.User;
import com.example.viki.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 注册
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ApiResponse register(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password
    ){
        try{
            userService.register(userId,password);
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return  ApiResponse.success();
    }

    /**
     * 登录
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ApiResponse login(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password
    ){
        User user = new User();
        try{
             user = userService.login(userId,password);
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.success(user);
    }

    /**
     * 获取轮播图图片url
     * @return
     */
    @RequestMapping(value = "getScrollerImage",method = RequestMethod.POST)
    public ApiResponse getScrollerImage(
    ){
        List list;
        try{
            list = userService.getScrollerImage();
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.success(list);
    }

    /**
     * 获得类别信息
     * @return
     */
    @RequestMapping(value = "getCategoryInfo",method = RequestMethod.POST)
    public ApiResponse getCategoryInfo(
    ){
        List list;
        try {
            list = userService.getCategoryInfo();
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.success(list);
    }

    /**
     * 获取火爆专区
     * @param page
     * @return
     */
    @RequestMapping(value = "homePageBelowContent",method = RequestMethod.POST)
    public ApiResponse homePageBelowContent(
            @RequestParam(value = "page") Integer page
    ){
        List list;
        try{
            list = userService.homePageBelowContent(page);
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.success(list);
    }

    /**
     * 获取所有商品
     * @return
     */
    @RequestMapping(value = "getGoods",method = RequestMethod.POST)
    public ApiResponse getGoods(
    ){
        List list;
        try{
            list = userService.getGoods();
        }catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.success(list);
    }

    /**
     * 获取分类
     * @return
     */
    @RequestMapping(value = "getCategory",method = RequestMethod.POST)
    public Map getCategory(
    ){
        Map<String,List<Category>> map = new HashMap<>();
        Category category;
        Goods goods;
        List<Category> list = new ArrayList<>() ;
        try{
            list = userService.getCategory();
        }catch (Exception e){
           // return ApiResponse.error(e.getMessage());
            e.printStackTrace();
        }
        map.put("data",list);
        //return ApiResponse.success(list);
        return map;
    }
}
