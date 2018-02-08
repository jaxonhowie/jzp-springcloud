package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * wrap ${@link org.jz.ext.steam.ApiDesc} api
     * @return
     */
    public JSONObject getAppList(){
        return null;
    }


}
