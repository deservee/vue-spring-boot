/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import java.util.List;
import com.xm.pojo.Customer;
import java.util.Map;

/**
 *
 * @author chenwei
 */
public interface  CustomerMapper {
     //模糊查询
    public  List<Map> selectCustomer(Map condition);
    //根据id查询的信息
    public  Map selectCustomerById(String id);
    //添加
    public Integer saveCustomer(Customer customer);
    //删除
    public Integer removeCustomer(String id);
    //修改
    public Integer modifyCustomer(Customer customer);
}