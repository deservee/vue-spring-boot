/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.controller;

import java.util.List;
import com.xm.mapper.PlaceMapper;
import com.xm.pojo.Place;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author PC
 */
@CrossOrigin
@RestController
@RequestMapping("/place")
public class PlaceController {
        @Autowired
	private PlaceMapper placeMapper;
	
	/**
	 * 查询场地
	 * @return
	 */
	@GetMapping("/select")
	public List<Place> select(){
            List<Place> places = placeMapper.selectPlace();
            return places; 
	}

        /**
	 * 插入
	 * @param place
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody Place place) {
            int rows=placeMapper.savePlace(place);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param place
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody Place place) {
            int rows=placeMapper.modifyPlace(place);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=placeMapper.removePlace(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}
}
