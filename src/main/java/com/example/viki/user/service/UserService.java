package com.example.viki.user.service;


import com.example.viki.user.repository.User;
import com.example.viki.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public void register(String userId, String password) throws Exception {
        if(checkUserIdIsExist(userId)){
            throw  new Exception("用户名已存在");
        }
        try{
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("注册失败");
        }
    }


    private boolean checkUserIdIsExist(String userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null){
            return false;
        }
        return true;
    }
}
