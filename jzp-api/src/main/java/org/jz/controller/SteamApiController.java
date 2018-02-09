package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.jz.commons.constant.SteamConstants;
import org.jz.ext.steam.ApiList;
import org.jz.model.steam.SteamApi;
import org.jz.service.SteamApiService;
import org.jz.util.CacheUtils;
import org.jz.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    private final static Logger logger = LoggerFactory.getLogger(SteamApiController.class);

    @Autowired
    ApiList apiList;

    @Autowired
    SteamApiService steamApiService;

    /**
     * wrap ${@link org.jz.ext.steam.ApiEnum} APIs
     * @return
     */
    @RequestMapping(value = "/apilist")
    public JSONObject getApiList() throws IOException {

        List<SteamApi> list = steamApiService.getAllApis();
        //judge cache if expired
        if (null!=list &&list.size()>0) {
            if (CacheUtils.isExpired(SteamConstants.API_LIST_CACHE,list.get(0).getOutime())) {
                steamApiService.delAll();
                //call external Api
                JSONObject rspJson = apiList.callApiList();
                list = apiList.parseToModel(rspJson);
                for (SteamApi steamApi : list) {
                    try {
                        steamApiService.insertSelective(steamApi);
                    } catch (Exception e) {
                        logger.error("Data insert exception:{}",e);
                    }
                }
            }
            return apiList.parseToJson(list);
        }
        //TODO 2018/2/9
        return null;
    }

}
