package com.zp.controller;

import com.alibaba.druid.util.StringUtils;
import com.zp.entity.User;
import com.zp.service.UserServcie;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin    //跨域问题
@RequestMapping("/user")
public class UsreController {

    @Autowired
    private UserServcie userServcie;

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userServcie.findall();
        return list;
    }

    @PostMapping("/saveUser")
    public Map saveUser(@RequestBody User user){
        Map<Object, Object> map = new HashMap<>();
        try{
            //根据用户有无id来判断执行保存或者更新
            if(StringUtils.isEmpty(user.getId())){
                userServcie.saveUser(user);
                map.put("success",true);
            }else {
                userServcie.updateUser(user);
                map.put("success",true);
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","用户保存或者更新失败");
        }
        return map;
    }

    @GetMapping("/deleteUser")
    public Map delUser(String id){
        HashMap<Object, Object> map = new HashMap<>();
        try{
            userServcie.deleteUser(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("msg","用户删除失败");
        }
        return map;
    }

    @GetMapping("/updateUser")
    public User updateUser(String id){
        return userServcie.findUserById(id);
    }

    //模糊查询
    @GetMapping("/findLike")
    public List<User> findNameOrPhone(String name, String phone){
        return userServcie.findNameOrPhone(name, phone);
    }
}
