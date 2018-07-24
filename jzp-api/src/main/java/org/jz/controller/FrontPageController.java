package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

@RestController
public class FrontPageController {

    @Autowired
    SteamApiController steamApiController;

    @RequestMapping("/index")
    public JSONObject sayHi(){
        JSONObject jo = new JSONObject();
        jo.put("I say:","Hi!");
        return jo;
    }

    @GetMapping("/home")
    public String homePage(){
        return "";
    }

}
