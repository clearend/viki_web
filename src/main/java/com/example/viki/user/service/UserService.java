package com.example.viki.user.service;


import com.example.viki.category.CategoryImage;
import com.example.viki.category.CategoryImageRepository;
import com.example.viki.category.CategoryTypeRepository;
import com.example.viki.dto.Category;
import com.example.viki.goods.Goods;
import com.example.viki.goods.GoodsRepository;
import com.example.viki.hotgoods.HotGoods;
import com.example.viki.hotgoods.HotGoodsRepository;
import com.example.viki.scroller.ScrollerImage;
import com.example.viki.scroller.ScrollerImageRepository;
import com.example.viki.user.repository.User;
import com.example.viki.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    @Resource
    ScrollerImageRepository scrollerImageRepository;

    @Resource
    CategoryImageRepository categoryImageRepository;

    @Resource
    HotGoodsRepository hotGoodsRepository;

    @Resource
    GoodsRepository goodsRepository;

    @Resource
    CategoryTypeRepository categoryTypeRepository;

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

    public User login(String userId, String password) throws Exception {
       User user = userRepository.findByUserIdAndPassword(userId,password);
       String token = "";
       if(user != null){
           token = DigestUtils.md5DigestAsHex((userId+System.currentTimeMillis()).getBytes());
           user.setToken(token);
           userRepository.save(user);
       } else {
           throw new Exception("账号/密码错误");
       }
       return user;
    }

    public List getScrollerImage() throws Exception {
        List<ScrollerImage> list;
        try {
            list  = scrollerImageRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("请求错误");
        }
        return list;
    }

    public List getCategoryInfo() throws Exception {
        List<CategoryImage> list;
        try {
            list = categoryImageRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("请求图片地址错误");
        }
        return list;
    }

    public List homePageBelowContent(Integer page) throws Exception {
        List<HotGoods> list = new ArrayList<>();
        List<HotGoods>list1 ;
        int length;
        try{
            list1 = hotGoodsRepository.findAll();
            if(page*10<list1.size()){
                length = page*10;
            }else {
                length = list1.size();
            }
            for(int i=(page-1)*10;i<length;i++) {
                list.add(list1.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("请求信息错误");
        }
        return list;

    }

    public List getGoods() {
        List<Goods> list;
        list = goodsRepository.findAll();
        return list;
    }

    public List getCategory() {
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        List<Goods> list = goodsRepository.findAll();
        List<Goods> list1 = new ArrayList<>();
        List<Goods> list2 = new ArrayList<>();
        List<Goods> list3 = new ArrayList<>();
        for(Goods goods : list) {
            if(goods.getMallCategoryId() == 1){
                list1.add(goods);
            }else if (goods.getMallCategoryId() == 2) {
                list2.add(goods);
            }else {
                list3.add(goods);
            }
        }
        category1.setMallCategoryId(1);
        category1.setComments(null);
        category1.setGoodsList(list1);
        category1.setMallCategoryName("食品类");
        category1.setImageUrl("http://121.36.0.188/tinyIcon/广东河源特产连平忠信萝卜爽.jpg");

        category2.setMallCategoryId(2);
        category2.setComments(null);
        category2.setGoodsList(list2);
        category2.setMallCategoryName("植物类");
        category2.setImageUrl("http://121.36.0.188/tinyIcon/广东钦州坭兴陶茶具地方特色工艺品.jpg");

        category3.setMallCategoryId(3);
        category3.setComments(null);
        category3.setGoodsList(list3);
        category3.setMallCategoryName("工艺品类");
        category3.setImageUrl("http://121.36.0.188/tinyIcon/广西桂林特产零食鱼干.jpg");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);

        return categoryList;
    }
}
