package org.jz.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hongyi Zheng
 * @date 2018/3/8
 */
public class Result {

    public static JSONObject buildJson(String transId, RspCode rspCode, String msg, Map<String,Object> data, boolean withBlankChar){
        rspCode = (null == rspCode? RspCode.SUCCESS : rspCode);
        Map<String,Object> map = new HashMap<>(4);
        //TODO  result
        return null;
    }

    public static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object o, String s, Object v) {
            if ( null == v) {
                return "";
            }
            return v;
        }
    };
}
