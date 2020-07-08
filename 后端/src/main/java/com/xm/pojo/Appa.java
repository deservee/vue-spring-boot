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
public class Appa {
    private String  id ;
    private String name ;
    private String  mill ;//购买地
    private String  model ;
    private String  price ;
    private String  createdate ;
    private String  remark ;

    public Appa() {
    }

    public Appa(String id, String name, String mill, String model, String price, String createdate, String remark) {
        this.id = id;
        this.name = name;
        this.mill = mill;
        this.model = model;
        this.price = price;
        this.createdate = createdate;
        this.remark = remark;
    }

//    public Appa(String string, String 测试部, String 测试部备注) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public Appa(String string, String 器材, String 购买地, String no01, int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

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

     public String getMill() {
        return mill;
    }

    public void setMill(String mill) {
        this.mill = mill;
    }
    
     public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
     public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
     public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
