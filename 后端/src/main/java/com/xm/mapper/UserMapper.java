/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import java.util.List;
import com.xm.pojo.User;

/**
 *
 * @author chenwei
 */
public interface  UserMapper {
    //查看列表
    public  List<User> selectUser();
    //添加
    public Integer saveUser(User user);
    //删除
    public Integer removeUser(String id);
    //修改
    public Integer modifyUser(User user);
    
    public User findOneByLoginname(String loginname) ;
}