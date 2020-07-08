package com.xm.controller;

import com.xm.pojo.RespBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AboutController {

    @GetMapping("/username")
    public String currentUserName() {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return currentUser;
    }
    
    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }
}
