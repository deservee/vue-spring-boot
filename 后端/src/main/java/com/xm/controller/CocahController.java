/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.controller;

import com.xm.mapper.CocahMapper;
import com.xm.pojo.Cocah;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@CrossOrigin
@RestController
@RequestMapping("/cocah")
public class CocahController {
    @Autowired
	private CocahMapper cocahMapper;
	
	/**
	 * 查询教练
	 * @return
	 */
	@GetMapping("/select")
	public List<Cocah> select(){
            List<Cocah> cocahs = cocahMapper.selectCocah();
            return cocahs; 
	}

        /**
	 * 插入
	 * @param cocah
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody Cocah cocah) {
            int rows=cocahMapper.saveCocah(cocah);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param cocah
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody Cocah cocah) {
            int rows=cocahMapper.modifyCocah(cocah);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=cocahMapper.removeCocah(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}
}
