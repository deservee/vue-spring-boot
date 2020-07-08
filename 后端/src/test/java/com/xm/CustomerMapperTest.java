package com.xm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import com.xm.pojo.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xm.mapper.CustomerMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chnewei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
     @Autowired
    private CustomerMapper customerMapper;
    
    @Test
    public void testSelectCustomer(){
        //调用selectEmployee方法
        Map<String,String> condition = new HashMap();
        condition.put("name","%杰%");
        condition.put("cocah","%0%");

        List<Map> map  = (List<Map>) customerMapper.selectCustomer(condition);
        System.out.println(map.toString());
    }
    @Test
    public void testSelectCustomerById(){
        //调用selectEmployee方法
        Map customer  = customerMapper.selectCustomerById("0101");
        System.out.println(customer.toString());
    }
    
    @Test
    public void testSaveCustomer(){
        // 创建Customer对象
	Customer customer= new Customer("3000","01","王丽","13902001111","251425887@qq.com","男","党员","1980-01-10","四大天王","2019-07-21");
	// 插入数据
        Integer rows  = customerMapper.saveCustomer(customer);
        System.out.println(rows.toString());
    }    
    
    @Test
    public void testModifyCustomer(){
        // 创建Employee对象
	Customer customer= new Customer("3000","01","王丽","13902001111","251425887@qq.com","男","党员","1980-01-10","四大天王","2019-07-21");
        // 修改Employee对象的属性值
        customer.setName("tom");
        customer.setSex("女");
	// 修改数据
        Integer rows  = customerMapper.modifyCustomer(customer);
        System.out.println(rows.toString());
    }    
    
    @Test
    public void testRemoveCustomer() throws Exception{
	// 删除数据
        Integer rows  = customerMapper.removeCustomer("3000");
        System.out.println(rows.toString());
    }        

}
