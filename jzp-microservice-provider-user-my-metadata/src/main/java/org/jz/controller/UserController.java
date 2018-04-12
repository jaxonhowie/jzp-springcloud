package org.jz.controller;

import org.jz.dao.UserRepository;
import org.jz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * practice from the book
 *
 * @author Hongyi Zheng
 * @date 2018/4/3
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        //spring boot 2.0.0版本不支持
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
}
