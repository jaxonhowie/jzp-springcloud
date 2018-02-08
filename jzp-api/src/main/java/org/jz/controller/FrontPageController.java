package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

@RestController
public class FrontPageController {

    @RequestMapping("/index")
    public JSONObject sayHi(){
        JSONObject jo = new JSONObject();
        jo.put("I say:","Hi!");
        return jo;
    }

}
