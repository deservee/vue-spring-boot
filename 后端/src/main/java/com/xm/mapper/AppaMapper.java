/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import com.xm.pojo.Appa;
import java.util.List;

/**
 *
 * @author PC
 */
public interface AppaMapper {
    //查看列表
    public  List<Appa> selectAppa();
    //添加
    public Integer saveAppa(Appa appa);
    //删除
    public Integer removeAppa(String id);
    //修改
    public Integer modifyAppa(Appa appa);

}
