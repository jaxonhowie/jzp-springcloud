package org.jz.ext.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hongyi Zheng
 * @date 2018/2/8
 */

public enum ApiEnum {

    /**
     * steam app list used in this artifact;
     */
    APPLIST(),GETNEWSFORAPP();

    private String url;

    private String appName;

    /**request parameters*/
    private Map<String,Object> arguments;

    /**response layout*/
    private String rspLayout;

    ApiEnum() {
    }

    ApiEnum(String url, String appName, Map<String, Object> arguments, String rspLayout) {
        this.url = url;
        this.appName = appName;
        this.arguments = arguments;
        this.rspLayout = rspLayout;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public String getRspLayout() {
        return rspLayout;
    }

    public void setRspLayout(String rspLayout) {
        this.rspLayout = rspLayout;
    }
}
