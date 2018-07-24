package org.jz.util;


import java.util.Date;

/**
 * 判断缓存是否过期
 *
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
public class CacheUtils {

    public static boolean isExpired(int cacheDays, Date outime)  {
        if (0 == cacheDays || null == outime) {
            return false;
        } else {
            return (outime.getTime() + (cacheDays * 1000 * 60 * 60 * 24)) < System.currentTimeMillis();
        }
    }

}
