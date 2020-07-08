/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import java.util.List;
import com.xm.pojo.Place;
/**
 *
 * @author PC
 */
public interface PlaceMapper {
    public  List<Place> selectPlace();
    //添加
    public Integer savePlace(Place place);
    //删除
    public Integer removePlace(String id);
    //修改
    public Integer modifyPlace(Place place);
}
