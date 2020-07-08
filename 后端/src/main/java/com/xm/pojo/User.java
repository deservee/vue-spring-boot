/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.pojo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author chnewei
 */
public class User implements UserDetails {
    private String  id ;
    private String loginname ;
    private String password;
    private String status;
    private String createdate;
    private String  username ;
    private String  role ;

    public User() {
    }

    public User(String id, String loginname, String password, String status, String createdate, String username, String role) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createdate = createdate;
        this.username = username;
        
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    
    @Override
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
    @Override
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     @Override
    public boolean isAccountNonExpired() {//是否过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//用户是否锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//用户凭证是否过期
        return true;
    }

    @Override
    public boolean isEnabled() {//用户是否启用
        return true;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        return authorities;
    }

}
