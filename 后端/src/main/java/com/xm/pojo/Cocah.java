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
public class Cocah {
    private String  id ;
    private String name ;
    private String phone ;
    private String createdate ;
    private String email ;
    private String sex ;
    private String party ;
    private String birthday ;
    private String  remark ;

    public Cocah() {
    }

    public Cocah(String id, String name, String phone, String createdate, String email,String sex, String party, String birthday, String remark) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.createdate = createdate;
        this.email = email;
        this.sex = sex;
        this.party = party;
        this.birthday = birthday;
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
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
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
}
