package com.zp.dao;

import com.zp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //查询所有
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(String id);
    //根据id查
    User findUserById(String id);

    void updateUser(User user);

    //模糊查询
    List<User> findNameOrPhone(@Param("name") String name,@Param("phone") String phone);
}
