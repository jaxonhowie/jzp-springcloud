package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.jz.common.constant.Constants;
import org.jz.common.constant.SteamConstants;
import org.jz.ext.steam.ApiListService;
import org.jz.ext.steam.AppListService;
import org.jz.model.steam.SteamApi;
import org.jz.model.steam.SteamApp;
import org.jz.service.SteamApiService;
import org.jz.service.SteamAppService;
import org.jz.util.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Get steam web api access:
 * Wiki:Most WebAPI methods take the following arguments in their URL:
 *      1.key:Your Steam Web API key. Without this, the server will return an HTTP 403 (forbidden) error.
 *      2.format(Optional):The file format to return output in.
 *          json (default):The JavaScript Object Notation format
 *          xml:Standard XML
 *      3.vdf:Valve Data Format
 *
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

@RestController
@RequestMapping("/steam")
public class SteamApiController {

    private final static Logger logger = LoggerFactory.getLogger(SteamApiController.class);

    @Autowired
    ApiListService apiListService;

    @Autowired
    SteamApiService steamApiService;

    @Autowired
    SteamAppService steamAppService;

    @Autowired
    AppListService appListService;

    /**
     * 获取steam接口列表（接口列表每次全量更新，先清后添加）
     *
     * wrap ${@link org.jz.ext.steam.ApiEnum} APIs
     * @return
     */
    @GetMapping("/apilist")
    public JSONObject getApiListService() throws IOException {

        logger.info("调用获取steam api 列表接口");

        //数据库结果
        List<SteamApi> dbList = steamApiService.queryAllIgnoreDel();
        //接口列表
        List<SteamApi> apiList;
        JSONObject rspJson = new JSONObject();
        //查询数据是否过期
        if (null!=dbList &&dbList.size()>0) {
            if (CacheUtils.isExpired(SteamConstants.API_LIST_CACHE,dbList.get(0).getOutime())) {
                //数据过期，清除过期数据
                steamApiService.delAll();
                rspJson = apiListService.callApiList();
                apiList = apiListService.parseToModel(rspJson);
                for (SteamApi steamApi : apiList) {
                    if (null != steamApiService.selectByName(steamApi.getName())) {
                        steamApi.setOutime(new Date());
                        steamApi.setIsDel(Constants.DEL_NGT);
                        try {
                            steamApiService.updateSelective(steamApi);
                        } catch (Exception e) {
                            logger.error("Data update exception:{}", e.getMessage());
                        }
                        continue;
                    }
                    try {
                        steamApiService.insertSelective(steamApi);
                    } catch (Exception e) {
                        logger.error("Data insert exception:{}", e.getMessage());
                    }
                }
            }else {
                apiList = dbList;
                rspJson = apiListService.parseToJson(apiList);
            }
        }else {
            //no cache,call external api
            rspJson = apiListService.callApiList();
            //落库
            apiList = apiListService.parseToModel(rspJson);
            for (SteamApi steamApi : apiList) {
                try {
                    steamApiService.insertSelective(steamApi);
                } catch (Exception e) {
                    logger.error("Data insert exception:{}",e.getMessage());
                }
            }

        }
        return rspJson;

    }

    /**
     * 获取steam APP 列表
     *
     * @return
     */
    @RequestMapping(value = "/applist")
    public JSONObject getAppListService() throws IOException {

        List<SteamApp> list = steamAppService.queryAll();
        JSONObject rspJson;

        if (null!=list &&list.size()>0) {
            if (CacheUtils.isExpired(SteamConstants.APP_LIST_CACHE,list.get(0).getOutime())) {
                steamAppService.delAll();

                //call external api
                rspJson = appListService.callAppListApi();
                list = appListService.parseToModel(rspJson);
                for (SteamApp app : list) {
                    try {
                        steamAppService.insertSelective(app);
                    } catch (Exception e) {
                        logger.error("Data insert exception:{}",e.getMessage());
                    }
                }
            }
            //缓存未过期,则直接返回结果
            return appListService.parseToJson(list);
        }else {
            //no cache,call external api
            rspJson = appListService.callAppListApi();
            //cache to db
            list = appListService.parseToModel(rspJson);
            for (SteamApp steamApp : list) {
                try {
                    steamAppService.insertSelective(steamApp);
                } catch (Exception e) {
                    logger.error("Data insert exception:{}",e.getMessage());
                }
            }
            return rspJson;
        }
    }
}
