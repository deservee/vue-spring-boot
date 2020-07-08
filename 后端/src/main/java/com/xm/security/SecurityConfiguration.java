/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xm.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity//开启Sping Security的功能
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
    @Autowired//完成自动配置
    CustomUserDetailsService customUserDetailsService;
    
    @Override//检验下面的方法名是否为父类所有，若不是则报错
    protected void configure(HttpSecurity http) throws Exception {
        //设置角色权限 
        http
            .authorizeRequests()
            //.antMatchers("/about/**").permitAll()  //任何用户都可以访问，可以不登录
            //.antMatchers("/home/**").hasAnyRole("ADMIN","USER")
            //.antMatchers("/man/**").hasRole("ADMIN")
            .antMatchers("/appamapper").hasRole("MAN01")
            .antMatchers("/cocahmapper").hasRole("MAN02")
            .antMatchers("/coursemapper").hasRole("MAN03")
            .antMatchers("/customermapper").hasRole("MAN04")
            .antMatchers("/placemapper").hasRole("MAN05")
                
            .anyRequest().authenticated() //其他没有授权的服务 登陆后才可以访问
               
            .and().formLogin().loginPage("/login_page")//当需要登录时，转到用户登录界面 指定登录界面
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                    out.flush();
                    out.close();
                     }
                })
            .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })
            .loginProcessingUrl("/login")//自定义的登录接口
            .usernameParameter("username").passwordParameter("password").permitAll()
            .and().logout().permitAll()
            //开启跨域 cors()
            .and().cors().configurationSource(corsConfigurationSource()) //开启跨域 cors()
            .and().csrf().disable()
                
            .exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
        http.rememberMe().rememberMeParameter("remember");
        
    }
   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置用户User 根据用户名 找到用户User，比对密码 获取role
        auth.userDetailsService(customUserDetailsService)//注入mybatis查询类
            .passwordEncoder(passwordEncoder());//密码校验类
        //权限登录
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("MAN01","MAN02","MAN03")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("MAN01","MAN04");
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }//密码校验规则
    
    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }//权限不足
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","/static/**");
    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password("12345678")
//            .roles("USER");
//        //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
//    }
    //spring security 配置跨域访问资源
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");  //header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");	//允许的请求方法，POST、GET等
        corsConfiguration.addExposedHeader("token"); //拓展header 浏览器放过redponse的token 不然跨域登录收不到token
        corsConfiguration.setAllowCredentials(true); //允许浏览器携带cookie 
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
        return source;
    }
}