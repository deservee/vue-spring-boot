/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.pojo;

/**
 *
 * @author PC
 */
public class Course {
    private String  id ;
    private String name ;
    private String cocah_id ;
    private String place_id ;
    private String creatdate ;
    private String  remark ;

    public Course() {
    }

    public Course(String id, String name, String cocah_id, String place_id, String creatdate, String remark) {
        this.id = id;
        this.name = name;
        this.cocah_id = cocah_id;
        this.place_id = place_id;
        this.creatdate = creatdate;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCocah_id() {
        return cocah_id;
    }

    public void setCocah_id(String cocah_id) {
        this.cocah_id = cocah_id;
    }
    
    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getCreatdate() {
        return creatdate;
    }
    
    public void setCreatdate(String creatdate) {
        this.creatdate = creatdate;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
