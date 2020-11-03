package com.zp;

import com.zp.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootVueApplication.class)
@RunWith(SpringRunner.class)
class SpringbootVueApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        userDao.findAll().forEach(user -> System.out.println("user"+user));
    }

}
