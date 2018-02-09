package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.jz.util.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Get steam web api access:
 * Wiki:Most WebAPI methods take the following arguments in their URL:
 *      1.key:Your Steam Web API key. Without this, the server will return an HTTP 403 (forbidden) error.
 *      2.format(Optional):The file format to return output in.
 *          json (default):The JavaScript Object Notation format
 *          xml:Standard XML
 *      3.vdf:Valve Data Format
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

@RestController
@RequestMapping("/steam")
public class SteamApiController {

    /**
     * wrap ${@link org.jz.ext.steam.ApiEnum} APIs
     * @return
     */
    @RequestMapping(value = "/apilist")
    public JSONObject getApiList() throws IOException {
        String url = "http://api.steampowered.com/ISteamWebAPIUtil/GetSupportedAPIList/v0001/";
        Map<String,String> params = new HashMap<>(1);
        String response = HttpClientUtils.doGet(url,params);
        return JSONObject.parseObject(response);
    }

}
