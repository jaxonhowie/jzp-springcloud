package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.jz.service.SteamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

@Controller
public class FrontPageController {

    @Autowired
    SteamApiService steamApiService;

    @RequestMapping("/index")
    public String sayHi(){
        return "index";
    }

    @RequestMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("", steamApiService.queryAllIgnoreDel());
        return "/api-list";
    }

}
