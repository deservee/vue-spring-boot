/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.controller;

import com.xm.mapper.CourseMapper;
import com.xm.pojo.Course;
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
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
	private CourseMapper courseMapper;
	
	/**
	 * 查询课程
	 * @return
	 */
	@GetMapping("/select")
	public List<Course> select(){
            List<Course> courses = courseMapper.selectCourse();
            return courses; 
	}

        /**
	 * 插入
	 * @param course
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody Course course) {
            int rows=courseMapper.saveCourse(course);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param course
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody Course course) {
            int rows=courseMapper.modifyCourse(course);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=courseMapper.removeCourse(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}

}
