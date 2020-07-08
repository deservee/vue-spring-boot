package com.xm.controller;

import static com.sun.xml.internal.fastinfoset.vocab.Vocabulary.PREFIX;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.xm.mapper.UserMapper;
import com.xm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询用户
	 * @return
	 */
	@GetMapping("/select")
	public List<User> select(){
            List<User> user = userMapper.selectUser();
            return user; 
	}

        /**
	 * 插入
	 * @param user
         * @return
	 */
	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
            int rows=userMapper.saveUser(user);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param user
         * @return
	 */
	@PutMapping("/update")
	public String update(@RequestBody User user) {
            int rows=userMapper.modifyUser(user);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
            int rows=userMapper.removeUser(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}
        @GetMapping("/appamapper/{path}")
        public String appamapper(@PathVariable("path")String path) {
            return PREFIX+"appamapper/"+path;
        }
        @GetMapping("/cocahmapper/{path}")
        public String cocahmapper(@PathVariable("path")String path) {
            return PREFIX+"cocahmapper/"+path;
        }
         @GetMapping("/coursemapper/{path}")
        public String coursemapper(@PathVariable("path")String path) {
        return PREFIX+"coursemapper/"+path;
        }
        @GetMapping("/customermapper/{path}")
        public String customermapper(@PathVariable("path")String path) {
            return PREFIX+"customermapper/"+path;
        }
        @GetMapping("/placemapper/{path}")
        public String placemapper(@PathVariable("path")String path) {
            return PREFIX+"placemapper/"+path;
        }
}
