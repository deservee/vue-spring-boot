/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.controller;

import com.xm.mapper.AppaMapper;
import com.xm.pojo.Appa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@CrossOrigin//解决跨域
@RestController
@RequestMapping("/appa")//请求地址映射
public class AppaController {
    @Autowired
	private AppaMapper appaMapper;
	
	/**
	 * 查询器材
	 * @return
	 */
	@GetMapping("/select")
	public List<Appa> select(){
            List<Appa> appas = appaMapper.selectAppa();
            return appas; 
	}

        /**
	 * 插入
	 * @param appa
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody Appa appa) {
            int rows=appaMapper.saveAppa(appa);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param appa
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody Appa appa) {
            int rows=appaMapper.modifyAppa(appa);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=appaMapper.removeAppa(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}
}
