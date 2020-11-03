package com.zp.service;

import com.zp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserServcie {
    List<User> findall();

    void saveUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    List<User> findNameOrPhone(@Param("name") String name, @Param("phone") String phone);


}
