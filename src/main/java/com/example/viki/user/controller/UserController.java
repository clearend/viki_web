package com.example.viki.user.controller;


import com.example.viki.common.ApiResponse;
import com.example.viki.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

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
}
