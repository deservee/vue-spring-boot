package com.xm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.xm.pojo.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xm.mapper.CustomerMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 查询
         * @param name
         * @param cocah
	 * @return
	 */
	@GetMapping("/select")
	public List<Map> select(@RequestParam("name") String name,@RequestParam("cocah") String cocah){
            Map<String, String> condition = new HashMap();
            condition.put("name", "%"+name+"%");
            condition.put("cocah", "%"+cocah+"%");
            List<Map> customers = customerMapper.selectCustomer(condition);
            return customers; 
	}
       
	/**
	 * 查询某雇员
         * @param id
	 * @return
	 */
	@GetMapping("/selectone/{id}")
	public Map selectone(@PathVariable("id") String id){
            Map customer = customerMapper.selectCustomerById(id);
            return customer; 
	}
        /**
	 * 插入
	 * @param customer
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody Customer customer) {
            int rows=customerMapper.saveCustomer(customer);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param customer
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody Customer customer) {
            int rows=customerMapper.modifyCustomer(customer);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=customerMapper.removeCustomer(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}

}
