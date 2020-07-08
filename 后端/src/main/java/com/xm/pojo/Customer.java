/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.pojo;

/**
 *
 * @author chnewei
 */
public class Customer {
    private String  id ;
    private String cocah_id ;
    private String name ;
    private String phone ;
    private String email ;
    private String sex ;
    private String party ;
    private String birthday ;
    private String  remark ;
    private String create_date ;

    public Customer() {
    }

    public Customer(String id, String cocah_id, String name, String phone, String email, String sex, String party, String birthday, String remark, String create_date) {
        this.id = id;
        this.cocah_id = cocah_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.party = party;
        this.birthday = birthday;
        this.remark = remark;
        this.create_date = create_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCocah_id() {
        return cocah_id;
    }

    public void setCocah_id(String cocah_id) {
        this.cocah_id = cocah_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
    
     public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
     public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
 
}
