package org.jz.util;


import java.util.Date;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
public class CacheUtils {

    public static boolean isExpired(int cacheDays, Date outime)  {
        if (0 == cacheDays || null == outime) {
            return false;
        } else {
            return outime.getTime()>getExpireTime(cacheDays);
        }
    }

    private static long getExpireTime(int cacheDays){
        long curr = System.currentTimeMillis();
        return curr + 24*60*60*1000*cacheDays;
    }

}
