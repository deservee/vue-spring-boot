/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.mapper;

import com.xm.pojo.Cocah;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CocahMapper {
    public  List<Cocah> selectCocah();
    //添加
    public Integer saveCocah(Cocah cocah);
    //删除
    public Integer removeCocah(String id);
    //修改
    public Integer modifyCocah(Cocah cocah);
}
