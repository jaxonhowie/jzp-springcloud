package org.jz.common.constant;

/**
 * @author Hongyi Zheng
 * @date 2018/2/8
 */
public class SteamConstants {

    /** steam web api key */
    public static final String STEAM_API_KEY = "67A2B3588C76DBA1A8408083BF7E0140";
    /** steam web api url */
    public static final String STEAM_PRIVATE_URL = "www.jz1989.org";

    //************************ApiListService Constants****************************

    public static final int API_LIST_CACHE = 1;

    public static final String API_LIST_URL = "http://api.steampowered.com/ISteamWebAPIUtil/GetSupportedAPIList/v0001/";

    //************************AppListService Constants****************************

    public static final String APP_LIST_URL = "http://api.steampowered.com/ISteamApps/GetAppList/v2";

    public static final int APP_LIST_CACHE = 30;

}
