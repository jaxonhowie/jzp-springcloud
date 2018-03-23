package org.jz.ext.steam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jz.common.constant.SteamConstants;
import org.jz.model.steam.SteamApi;
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
 * @date 2018/2/9
 */

@Component("apiListService")
public class ApiListService {

    private static final Logger logger = LoggerFactory.getLogger(ApiListService.class);

    public List<SteamApi> parseToModel(JSONObject rspJson){
        List<SteamApi> list = new ArrayList<>();
        JSONArray ja = rspJson.getJSONObject("apilist").getJSONArray("interfaces");
        for (Object o : ja) {
            JSONObject jo = (JSONObject) o;
            SteamApi api = new SteamApi();
            api.setName(jo.get("name").toString());
            api.setMethods(jo.get("methods").toString());
            list.add(api);
        }
        return list;
    }

    public JSONObject callApiList() throws IOException {
        String url = SteamConstants.API_LIST_URL;
        Map<String,String> params = new HashMap<>(1);
        String response = HttpClientUtils.doGet(url,params);
        JSONObject rspJson = JSONObject.parseObject(response);
        return JSONObject.parseObject(response);
    }

    public JSONObject parseToJson(List<SteamApi> list){

        JSONObject rspJson = new JSONObject();
        JSONArray interfaces = new JSONArray();
        JSONObject jo = new JSONObject();
        JSONArray ja;
        for (SteamApi steamApi : list) {
            jo.put("name",steamApi.getName());
            ja = JSONArray.parseArray(steamApi.getMethods());
            jo.put("methods",ja);
            interfaces.add(jo);
        }
        rspJson.put("interfaces",interfaces);
        return rspJson;
    }

}
