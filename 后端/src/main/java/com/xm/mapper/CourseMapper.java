/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import java.util.List;
import com.xm.pojo.Course;

/**
 *
 * @author PC
 */
public interface CourseMapper {
    public  List<Course> selectCourse();
    //添加
    public Integer saveCourse(Course course);
    //删除
    public Integer removeCourse(String id);
    //修改
    public Integer modifyCourse(Course course);
}
