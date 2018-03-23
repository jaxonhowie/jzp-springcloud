package org.jz.ext.steam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jz.common.constant.SteamConstants;
import org.jz.model.steam.SteamApp;
import org.jz.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */
@Component("appListService")
public class AppListService {

    private final static Logger logger = LoggerFactory.getLogger(AppListService.class);

    public List<SteamApp> parseToModel(JSONObject rspJson) throws IOException {
        List<SteamApp> list = new ArrayList<>();
        JSONArray ja = rspJson.getJSONObject("applist").getJSONArray("apps");
        for (Object o : ja) {
            JSONObject jo = (JSONObject) o;
            SteamApp app = new SteamApp();
            app.setName(jo.get("name").toString());
            app.setAppId(jo.get("appid").toString());
            list.add(app);
        }
        return list;
    }

    public JSONObject parseToJson(List<SteamApp> list){
        JSONObject rspJson = new JSONObject();
        JSONArray apps = new JSONArray();
        for (SteamApp app : list) {
            JSONObject jo = new JSONObject();
            jo.put("name",app.getName());
            jo.put("appid",app.getAppId());
            apps.add(jo);
        }
        rspJson.put("apps",apps);
        return rspJson;
    }

    public JSONObject callAppListApi() throws IOException {
        String url = SteamConstants.APP_LIST_URL;
        Map<String,String> params = new HashMap<>(1);
        String response = HttpClientUtils.doGet(url,params);
        JSONObject rspJson = JSONObject.parseObject(response);
        return JSONObject.parseObject(response);
    }
}
