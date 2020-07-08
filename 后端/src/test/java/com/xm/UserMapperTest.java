package com.xm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import com.xm.pojo.User;
import com.xm.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author chnewei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
 
    @Test
    public void testSelectUser(){
        //调用selectUser方法
        List<User> dept  = userMapper.selectUser();
        System.out.println(dept.toString());
    }
    
    @Test
    public void testSaveUser(){
         // 创建User对象
	User user= new User("0300","测试部2", "测试部2备注","测试部2备注","测试部2备注","测试部2备注","测试部2备注");
	// 插入数据
        Integer rows  = userMapper.saveUser(user);
        System.out.println(rows.toString());
    }    
    
    @Test
    public void testModifyUser(){
        // 创建User对象
	User user = new User();
        // 修改User对象的属性值
        user.setId("0300");
        user.setLoginname("测试部2");
        user.setPassword("测试部2备注");
        user.setStatus("测试部2备注");
        user.setCreatedate("测试部2备注");
        user.setUsername("测试部2备注");

	// 修改数据
        Integer rows  = userMapper.modifyUser(user);
        System.out.println(rows.toString());
    }    
    
    @Test
    public void testRemoveUser(){
 	// 删除数据
        Integer rows  = userMapper.removeUser("0300");
        System.out.println(rows.toString());
    }        

}
