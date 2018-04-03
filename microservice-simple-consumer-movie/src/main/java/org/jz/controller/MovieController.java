package org.jz.controller;

import org.jz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hongyi Zheng
 * @date 2018/4/3
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用restTemplate请求provider微服务api
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8000/"+id, User.class);
    }
}
